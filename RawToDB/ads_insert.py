import datetime


INSERT_INTO_ADS = "INSERT INTO `ads` (`id`, `Location`, `State`, `Date`, `Age`, `FullText`) VALUES (%s, %s, %s, %s, %s, %s);"


def ads_insert(processed_db, row):
  id = row[0]
  location = str(row[-3])
  state = row[-2]
  date = datetime.datetime.strftime(row[1], "%Y-%m-%d")
  full_text = row[3].upper() + row[4].upper()
  processed_db.cursor.execute(INSERT_INTO_ADS, (id, location, state, date, None, full_text))
  processed_db.conn.commit()