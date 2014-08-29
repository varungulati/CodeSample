import global_constants

from build_connection import MySQLConnection
from shard import Shard


raw_db = MySQLConnection(db=global_constants.RAW_DB)
processed_db = MySQLConnection(db=global_constants.PROCESSED_DB)

raw_db.cursor.execute('SELECT COUNT(*) FROM raw_ads;')
RAW_ADS_COUNT = raw_db.cursor.fetchone()[0]
raw_db.cursor.execute('SELECT COUNT(*) FROM raw_ads_images;')
RAW_ADS_IMAGES_COUNT = raw_db.cursor.fetchone()[0]

RAW_ADS_COUNT = 100
RAW_ADS_IMAGES_COUNT = 100
print RAW_ADS_IMAGES_COUNT

RAW_ADS_PER_THREAD = int(RAW_ADS_COUNT/(global_constants.MAX_THREAD-1))
RAW_ADS_IMAGES_PER_THREAD = int(RAW_ADS_IMAGES_COUNT/(global_constants.MAX_THREAD-1))

for i in range(global_constants.MAX_THREAD):
  Shard(i, RAW_ADS_PER_THREAD, connect_database=True).start()
