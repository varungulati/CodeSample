
import global_constants

INSERT_TEMPLATE = 'INSERT INTO `%s` (`ads_id`, `Image`) VALUES ' % global_constants.ADS_IMAGES
INSERT_INTO_ADS_IMAGES = INSERT_TEMPLATE + "(%s, %s);"


def ads_images_insert(processed_db, row):
  id = row[0]
  image = row[1]
  processed_db.cursor.execute(INSERT_INTO_ADS_IMAGES, (id, image))
  processed_db.conn.commit()

