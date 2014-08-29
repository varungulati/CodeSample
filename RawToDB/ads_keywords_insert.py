import keywords
import global_constants
import threading

INSERT_TEMPLATE = 'INSERT INTO `%s` (`ads_id`, `Attribute`) VALUES ' % global_constants.ADS_KEYWORDS
INSERT_INTO_ADS_KEYWORDS = INSERT_TEMPLATE + "(%s, %s);"


def ads_keywords_insert(processed_db, row):
  id = row[0]
  full_text = row[3].upper() + row[4].upper()
  # for i in range(keywords.KEYWORDS.__len__()):
  for keyword in keywords.KEYWORDS:
    # print InsertHelper(keyword, full_text).start()
    InsertHelper(id, keyword, full_text, processed_db).start()
      # processed_db.cursor.execute(INSERT_INTO_ADS_KEYWORDS, (id, keyword))
      # processed_db.conn.commit()
  # for keyword in keywords.KEYWORDS:
  #   if keyword in full_text:
  #     processed_db.cursor.execute(INSERT_INTO_ADS_KEYWORDS, (id, keyword))
  #     processed_db.conn.commit()


class InsertHelper(threading.Thread):
  def __init__(self, id, keyword, full_text, processed_db):
    threading.Thread.__init__(self)
    self.id = id
    self.keyword = keyword
    self.full_text = full_text
    self.processed_db = processed_db

  def run(self):
    if self.keyword in self.full_text:
      self.processed_db.cursor.execute(INSERT_INTO_ADS_KEYWORDS, (self.id, self.keyword))
      self.processed_db.conn.commit()
