import MySQLdb

class MySQLConnection:
  def __init__(self, host="128.2.177.192", user='root', passwd='autonroot', db='TJ'):
    self.conn = MySQLdb.connect(host= host, user=user, passwd=passwd, db=db)
    self.cursor = self.conn.cursor()

  def execute_command(self, command):
    try:
      self.cursor.execute(command)
      self.conn.commit()
      return 0
    except:
      print "ERROR in query: ", command
      self.conn.rollback()
      return -1

  def get_last_insert_id(self):
    return self.cursor.lastrowid

  def close(self):
    self.conn.close()
