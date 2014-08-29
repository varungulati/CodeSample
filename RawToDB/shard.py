
import threading
import global_constants

from ads_insert import ads_insert
from ads_images_insert import ads_images_insert
from ads_keywords_insert import ads_keywords_insert
from build_connection import MySQLConnection


class Shard(threading.Thread):
  thread_num = -1

  def __init__(self, thread_num, load_ads_per_thread, connect_database=True):
    threading.Thread.__init__(self)
    self.thread_num = thread_num
    self.load_ads_per_thread = load_ads_per_thread
    self.connect_database = connect_database

  def run(self):
    if not self.connect_database:
      return
    try:
      raw_db = MySQLConnection(db=global_constants.RAW_DB)
      # print "Connected to TJ_raw by thread: ", self.thread_num
      processed_db = MySQLConnection(db=global_constants.PROCESSED_DB)
      # print "Connected to TJ_test by thread: ", self.thread_num
    except e:
      print e
      return

    raw_db.cursor.execute('SELECT * FROM raw_ads limit %s, %s', (self.thread_num*self.load_ads_per_thread, self.load_ads_per_thread))

    for row in raw_db.cursor.fetchall():
      ad_id = row[0]
      ads_insert(processed_db, row)
      ads_keywords_insert(processed_db, row)

      raw_db.cursor.execute('SELECT * FROM raw_ads_images WHERE ads_id=%s' % ad_id)

      for row in raw_db.cursor.fetchall():
        ads_images_insert(processed_db, row)

    raw_db.close()
    processed_db.close()
    # print "Thread %s DONE" % self.thread_num

