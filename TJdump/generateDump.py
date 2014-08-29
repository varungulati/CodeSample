import os
import datetime
import subprocess

# Number of reows in traffic jam.cas
# Number of rows in images array.
# Number of rows in phone.

###############################TABLE ads############################
DROP_TABLE_ADS = """\nDROP TABLE IF EXISTS `ads`;\n"""
CREATE_ADS = """CREATE TABLE `ads` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,
`Location` VARCHAR(20) DEFAULT NULL,
`State` CHAR(2) DEFAULT NULL,
`Date` DATE DEFAULT NULL,
`Age` int(11) DEFAULT NULL,
`FullText` text DEFAULT NULL,
PRIMARY KEY (`id`)
);\n"""
LOCK_TABLE = "LOCK TABLES `ads` WRITE;\n"
INSERT_INTO_ADS = "\nINSERT INTO `ads` VALUES "

###########################TABLE ads_keywords############################
DROP_TABLE_ADS_KEYWORDS = """\nDROP TABLE IF EXISTS `ads_keywords`;\n"""
CREATE_ADS_KEYWORDS = """CREATE TABLE `ads_keywords` (
`ads_id` bigint(11) NOT NULL,
`Attribute` VARCHAR(20),
FOREIGN KEY (ads_id) REFERENCES ads(id)
);\n"""
LOCK_TABLE_KEYWORDS = "LOCK TABLES `ads_keywords` WRITE;\n"
INSERT_INTO_ADS_KEYWORDS = "\nINSERT INTO `ads_keywords` VALUES "

###############################TABLE ads_phones############################
DROP_TABLE_ADS_PHONES = """\nDROP TABLE IF EXISTS `ads_phones`;\n"""
CREATE_ADS_PHONES = """CREATE TABLE `ads_phones` (
`ads_id` bigint(11) NOT NULL,
`Phone` CHAR(10) DEFAULT NULL,
FOREIGN KEY (ads_id) REFERENCES ads(id)
);\n"""
LOCK_TABLE_PHONES = "LOCK TABLES `ads_phones` WRITE;\n"
INSERT_INTO_ADS_PHONES = "\nINSERT INTO `ads_phones` VALUES "

###############################TABLE ads_emails############################
DROP_TABLE_ADS_EMAILS = """\nDROP TABLE IF EXISTS `ads_emails`;\n"""
CREATE_ADS_EMAILS = """CREATE TABLE `ads_emails` (
`ads_id` bigint(11) NOT NULL,
`Email` VARCHAR(255) DEFAULT NULL,
FOREIGN KEY (ads_id) REFERENCES ads(id)
);\n"""
LOCK_TABLE_EMAILS = "LOCK TABLES `ads_emails` WRITE;\n"
INSERT_INTO_ADS_EMAILS = "\nINSERT INTO `ads_emails` VALUES "

###############################TABLE ads_images############################
DROP_TABLE_ADS_IMAGES = """\nDROP TABLE IF EXISTS `ads_images`;\n"""
CREATE_ADS_IMAGES = """CREATE TABLE `ads_images` (
`ads_id` bigint(11) NOT NULL,
`Image` VARCHAR(255),
FOREIGN KEY (ads_id) REFERENCES ads(id)
);\n"""
LOCK_TABLE_IMAGES = "LOCK TABLES `ads_images` WRITE;\n"
INSERT_INTO_ADS_IMAGES = "\nINSERT INTO `ads_images` VALUES "

###############################TABLE ads_misc############################
DROP_TABLE_ADS_MISC = """\nDROP TABLE IF EXISTS `ads_misc`;\n"""
CREATE_ADS_MISC = """CREATE TABLE `ads_misc` (
`ads_id` bigint(11) NOT NULL,
`Attribute` VARCHAR(200),
`Value` VARCHAR(255),
FOREIGN KEY (ads_id) REFERENCES ads(id)
);\n"""
LOCK_TABLE_MISC = "LOCK TABLES `ads_misc` WRITE;\n"
INSERT_INTO_ADS_MISC = "\nINSERT INTO `ads_misc` VALUES "

PATH_SOURCE = '/home/vgulati/trafficjam_060414/preload/trafficjam_mock.csv'
PATH_SOURCE_IMAGE = '/home/vgulati/trafficjam_060414/preload/images_array_mock.txt'
PATH_SOURCE_ADDITIONAL_PHONE = '/home/vgulati/trafficjam_060414/preload/phone_mock.txt'

source = open(PATH_SOURCE, 'r')
source_image = open(PATH_SOURCE_IMAGE, 'r')
source_additional_phone = open(PATH_SOURCE_ADDITIONAL_PHONE)

destinations = {
    'ads': '/home/vgulati/databaseDebug/ads.csv',
    'ads_keywords': '/home/vgulati/databaseDebug/ads_keywords.csv',
    'ads_phones': '/home/vgulati/databaseDebug/ads_phones.csv',
    'ads_images': '/home/vgulati/databaseDebug/ads_images.csv',
    'ads_emails': '/home/vgulati/databaseDebug/ads_emails.csv',
    'ads_misc': '/home/vgulati/databaseDebug/ads_misc.csv',
    'results': '/home/vgulati/databaseDebug/result.sql',
}
destination_ads = open(destinations.get('ads'), 'w')
destination_ads.write(DROP_TABLE_ADS)
destination_ads.write(CREATE_ADS)
destination_ads.write(LOCK_TABLE)

destination_ads_keywords = open(destinations.get('ads_keywords'), 'w')
destination_ads_keywords.write(DROP_TABLE_ADS_KEYWORDS)
destination_ads_keywords.write(CREATE_ADS_KEYWORDS)
destination_ads_keywords.write(LOCK_TABLE_KEYWORDS)
# destination_ads_keywords.write(INSERT_INTO_ADS_KEYWORDS)

destination_ads_phones = open(destinations.get('ads_phones'), 'w')
destination_ads_phones.write(DROP_TABLE_ADS_PHONES)
destination_ads_phones.write(CREATE_ADS_PHONES)
destination_ads_phones.write(LOCK_TABLE_PHONES)
# destination_ads_phones.write(INSERT_INTO_ADS_PHONES)

destination_ads_images = open(destinations.get('ads_images'), 'w')
destination_ads_images.write(DROP_TABLE_ADS_IMAGES)
destination_ads_images.write(CREATE_ADS_IMAGES)
destination_ads_images.write(LOCK_TABLE_IMAGES)
# destination_ads_images.write(INSERT_INTO_ADS_IMAGES)

destination_ads_emails = open(destinations.get('ads_emails'), 'w')
destination_ads_emails.write(DROP_TABLE_ADS_EMAILS)
destination_ads_emails.write(CREATE_ADS_EMAILS)
destination_ads_emails.write(LOCK_TABLE_EMAILS)
# destination_ads_emails.write(INSERT_INTO_ADS_EMAILS)

destination_ads_misc = open(destinations.get('ads_misc'), 'w')
destination_ads_misc.write(DROP_TABLE_ADS_MISC)
destination_ads_misc.write(CREATE_ADS_MISC)
destination_ads_misc.write(LOCK_TABLE_MISC)
# destination_ads_misc.write(INSERT_INTO_ADS_MISC)

ads_values = ''
ads_keywords_values = ''
ads_phones_values = ''
ads_images_values = ''
ads_emails_values = ''
ads_misc_values = ''

ads_values_prev = ''
ads_keywords_values_prev = ''
ads_phones_values_prev = ''
ads_images_values_prev = ''
ads_emails_values_prev = ''
ads_misc_values_prev = ''

insert_into_ads = False
insert_into_ads_phones = False
insert_into_ads_emails = False
insert_into_ads_keywords = False
insert_into_ads_images = False
insert_into_ads_misc = False

# Skip headers by reading first line.
source.next()
count = 1
MAX_INSERT_COUNT = 3000
insert_count_ads = 0
insert_count_phone = 0
insert_count_ads_keywords = 0
insert_count_ads_images = 0
insert_count_additional_phones = 0
TOTAL_RECORDS_COUNT_ADS = int(subprocess.check_output('wc -l ' + PATH_SOURCE, shell=True).split(" ")[0]) - 1
TOTAL_RECORDS_COUNT_ADS_IMAGES = int(subprocess.check_output('wc -l ' + PATH_SOURCE_IMAGE, shell=True).split(" ")[0]) - 1
TOTAL_RECORDS_COUNT_ADDITIONAL_PHONES = int(subprocess.check_output('wc -l ' + PATH_SOURCE_ADDITIONAL_PHONE, shell=True).split(" ")[0]) - 1

for line in source:
  l = line.split(',')
  # ID
  id = str(count)
  # Location
  location = l[0] = '"' + l[0] + '"'
  # State
  state = l[1] = '"' + l[1] + '"'
  # Date
  l[2] = datetime.datetime.strptime(l[2], "%b/%d/%Y")
  l[2] = l[2].strftime("%Y-%m-%d")
  date = l[2] = '"' + l[2] + '"'
  # Age
  age = l[3]
  # Size
  size = l[4] = '"' + l[4] + '"'
  # Phone
  phone = '"' + l[5] + l[6] + l[7] + '"'
  # Feature
  keywords = []
  if l[8] == "1":
    keywords.append("ADORABLE")
  if l[9] == "1":
    keywords.append("ASIAN")
  if l[10] == "1":
    keywords.append("AVAILABLE")
  if l[11] == "1":
    keywords.append("BABY")
  if l[12] == "1":
    keywords.append("BACK")
  if l[13] == "1":
    keywords.append("BAD")
  if l[14] == "1":
    keywords.append("BEAUTIFUL")
  if l[15] == "1":
    keywords.append("BEAUTY")
  if l[16] == "1":
    keywords.append("BEST")
  if l[17] == "1":
    keywords.append("BLACK")
  if l[18] == "1":
    keywords.append("BLOCKED")
  if l[19] == "1":
    keywords.append("BLONDE")
  if l[20] == "1":
    keywords.append("BODY")
  if l[21] == "1":
    keywords.append("BROWN")
  if l[22] == "1":
    keywords.append("BRUNETTE")
  if l[23] == "1":
    keywords.append("BUSTY")
  if l[24] == "1":
    keywords.append("CALL")
  if l[25] == "1":
    keywords.append("CLASSY")
  if l[26] == "1":
    keywords.append("CLEAN")
  if l[27] == "1":
    keywords.append("COMPANIONSHIP")
  if l[28] == "1":
    keywords.append("CURVES")
  if l[29] == "1":
    keywords.append("CUTE")
  if l[30] == "1":
    keywords.append("DAY")
  if l[31] == "1":
    keywords.append("DISCREET")
  if l[32] == "1":
    keywords.append("DON")
  if l[33] == "1":
    keywords.append("DOWN")
  if l[34] == "1":
    keywords.append("ENJOY")
  if l[35] == "1":
    keywords.append("EXOTIC")
  if l[36] == "1":
    keywords.append("EXPERIENCE")
  if l[37] == "1":
    keywords.append("EYES")
  if l[38] == "1":
    keywords.append("FACE")
  if l[39] == "1":
    keywords.append("FREE")
  if l[40] == "1":
    keywords.append("FRIENDLY")
  if l[41] == "1":
    keywords.append("FULL")
  if l[42] == "1":
    keywords.append("FUN")
  if l[43] == "1":
    keywords.append("GENTLEMEN")
  if l[44] == "1":
    keywords.append("GIRLS")
  if l[45] == "1":
    keywords.append("GOOD")
  if l[46] == "1":
    keywords.append("GORGEOUS")
  if l[47] == "1":
    keywords.append("GUYS")
  if l[48] == "1":
    keywords.append("HAIR")
  if l[49] == "1":
    keywords.append("HOT")
  if l[50] == "1":
    keywords.append("HOUR")
  if l[51] == "1":
    keywords.append("INCALL")
  if l[52] == "1":
    keywords.append("INDEPENDENT")
  if l[53] == "1":
    keywords.append("LADY")
  if l[54] == "1":
    keywords.append("LEAVE")
  if l[55] == "1":
    keywords.append("LIFE")
  if l[56] == "1":
    keywords.append("LIKE")
  if l[57] == "1":
    keywords.append("LONG")
  if l[58] == "1":
    keywords.append("LOOK")
  if l[59] == "1":
    keywords.append("LOOKING")
  if l[60] == "1":
    keywords.append("LOVE")
  if l[61] == "1":
    keywords.append("MASSAGE")
  if l[62] == "1":
    keywords.append("MATURE")
  if l[63] == "1":
    keywords.append("MEET")
  if l[64] == "1":
    keywords.append("MEN")
  if l[65] == "1":
    keywords.append("MILITARY")
  if l[66] == "1":
    keywords.append("MINDED")
  if l[67] == "1":
    keywords.append("MISS")
  if l[68] == "1":
    keywords.append("NAME")
  if l[69] == "1":
    keywords.append("NATURAL")
  if l[70] == "1":
    keywords.append("NEED")
  if l[71] == "1":
    keywords.append("NEW")
  if l[72] == "1":
    keywords.append("NICE")
  if l[73] == "1":
    keywords.append("NIGHT")
  if l[74] == "1":
    keywords.append("OFFER")
  if l[75] == "1":
    keywords.append("OPEN")
  if l[76] == "1":
    keywords.append("OUTCALL")
  if l[77] == "1":
    keywords.append("PERFECT")
  if l[78] == "1":
    keywords.append("PERSONALITY")
  if l[79] == "1":
    keywords.append("PETITE")
  if l[80] == "1":
    keywords.append("PHONE")
  if l[81] == "1":
    keywords.append("PICS")
  if l[82] == "1":
    keywords.append("PICTURES")
  if l[83] == "1":
    keywords.append("PLAY")
  if l[84] == "1":
    keywords.append("PLEASE")
  if l[85] == "1":
    keywords.append("PLEASURE")
  if l[86] == "1":
    keywords.append("PRIVATE")
  if l[87] == "1":
    keywords.append("REAL")
  if l[88] == "1":
    keywords.append("RIGHT")
  if l[89] == "1":
    keywords.append("RUSH")
  if l[90] == "1":
    keywords.append("RUSHED")
  if l[91] == "1":
    keywords.append("RUSSIAN")
  if l[92] == "1":
    keywords.append("SATISFACTION")
  if l[93] == "1":
    keywords.append("SEDUCTIVE")
  if l[94] == "1":
    keywords.append("SENSUAL")
  if l[95] == "1":
    keywords.append("SERIOUS")
  if l[96] == "1":
    keywords.append("SERVICE")
  if l[97] == "1":
    keywords.append("SEXY")
  if l[98] == "1":
    keywords.append("SHORT")
  if l[99] == "1":
    keywords.append("SKIN")
  if l[100] == "1":
    keywords.append("SMILE")
  if l[101] == "1":
    keywords.append("SOFT")
  if l[102] == "1":
    keywords.append("SPECIAL")
  if l[103] == "1":
    keywords.append("SUPER")
  if l[104] == "1":
    keywords.append("SWEET")
  if l[105] == "1":
    keywords.append("TEXT")
  if l[106] == "1":
    keywords.append("TIME")
  if l[107] == "1":
    keywords.append("TINY")
  if l[108] == "1":
    keywords.append("TOWN")
  if l[109] == "1":
    keywords.append("TREAT")
  if l[110] == "1":
    keywords.append("UPSCALE")
  if l[111] == "1":
    keywords.append("WAITING")
  if l[112] == "1":
    keywords.append("WANT")
  if l[113] == "1":
    keywords.append("WOMAN")
  if l[114] == "1":
    keywords.append("YOURSELF")
  if l[115] == "1":
    keywords.append("YOUNG")
  if l[116] == "1":
    keywords.append("_VIRGIN_")
  if l[117] == "1":
    keywords.append("FRESH")
  if l[118] == "1":
    keywords.append("CANDY")
  if l[119] == "1":
    keywords.append("NEW_GAME")
  if l[120] == "1":
    keywords.append("TEEN")
  if l[121] == "1":
    keywords.append("ADORABLEPLAYMATES")
  if l[122] == "1":
    keywords.append("GIRL_NEXT_DOOR")
  # Full text
  full_text = l[-1] = '"' + l[-1].split('\n')[0] + '"'
  
  insert_count_ads += 1
  # Write to destination ads.
  value_ads = '(' + id + ',' + location + ',' + state + ',' + date + ',' + age + ',' + full_text + ')'
  if insert_count_ads == MAX_INSERT_COUNT or count == TOTAL_RECORDS_COUNT_ADS:
    destination_ads.write(value_ads + ';')
  elif insert_count_ads == 1:
    destination_ads.write(INSERT_INTO_ADS + value_ads + ',')
  else:
    destination_ads.write(value_ads + ',')

  # Write to destination ads phones.
  if phone != "\"NoneNoneNone\"":
    insert_count_phone += 1
    value_phone = '(' + id + ',' + phone + ')'
    if insert_count_phone == MAX_INSERT_COUNT or count == TOTAL_RECORDS_COUNT_ADS:
      destination_ads_phones.write(value_phone + ';')
    elif insert_count_phone == 1:
      destination_ads_phones.write(INSERT_INTO_ADS_PHONES + value_phone + ',')
    else:
      destination_ads_phones.write(value_phone + ',')
  
  # Write to destination ads keywords.
  for elem in keywords:
    insert_count_ads_keywords += 1
    value_ads_keywords = ('(' + id + ',"' + elem + '")')
    if insert_count_ads_keywords == MAX_INSERT_COUNT or (count == TOTAL_RECORDS_COUNT_ADS and elem == keywords[-1]):
      destination_ads_keywords.write(value_ads_keywords + ';')
    elif insert_count_ads_keywords == 1:
      destination_ads_keywords.write(INSERT_INTO_ADS_KEYWORDS + value_ads_keywords + ',')
    else:
      destination_ads_keywords.write(value_ads_keywords + ',')
    if insert_count_ads_keywords == MAX_INSERT_COUNT:
      insert_count_ads_keywords = 0

  # Write to destination image.
  image_line = ''
  next_source_list = source_image.next().split(';')[1:]
  for elem in next_source_list:
    insert_count_ads_images += 1
    value_ads_images = '(' + str(id) + ',"' + elem.split('\n')[0] + '")'
    if insert_count_ads_images == MAX_INSERT_COUNT or (count == TOTAL_RECORDS_COUNT_ADS_IMAGES and elem == next_source_list[-1]):
      destination_ads_images.write(value_ads_images + ';')
    elif insert_count_ads_images  == 1:
      destination_ads_images.write(INSERT_INTO_ADS_IMAGES + value_ads_images + ',')
    else:
      destination_ads_images.write(value_ads_images + ',')
    if insert_count_ads_images == MAX_INSERT_COUNT:
      insert_count_ads_images = 0

  count = count + 1
  if insert_count_ads == MAX_INSERT_COUNT:
    insert_count_ads = 0
  if insert_count_phone == MAX_INSERT_COUNT:
    insert_count_phone = 0

destination_ads.flush()
destination_ads_keywords.flush()
destination_ads_images.flush()
destination_ads_emails.flush()
destination_ads_phones.flush()
destination_ads_misc.flush()

# Replace comma at the end of ads images.csv with a semicolon.
os.system("sed -i '$s/.$/\;\\nUNLOCK TABLES\;/' " + destinations['ads_images'])

destination_ads.write("\nUNLOCK TABLES;")
destination_ads_keywords.write("\nUNLOCK TABLES;")
destination_ads_images.write("\nUNLOCK TABLES;")
destination_ads_emails.write("\nUNLOCK TABLES;")
destination_ads_phones.write("\nUNLOCK TABLES;")
destination_ads_misc.write("\nUNLOCK TABLES;")

destination_ads.flush()
destination_ads_keywords.flush()
destination_ads_images.flush()
destination_ads_emails.flush()
destination_ads_phones.flush()
destination_ads_misc.flush()

destination_ads.close()
destination_ads_keywords.close()
destination_ads_images.close()
destination_ads_emails.close()
destination_ads_phones.close()
destination_ads_misc.close()

# Concatenate all destination files into one file.
#with open("/home/vgulati/result.sql", "wb") as outfile:
#    for f in sorted(destinations.values()):
#        with open(f, "rb") as infile:
#            for line in infile.readlines():
#              outfile.write(line)
#              outfile.flush()
        # Remove/delete intermediate destination files.
        # os.remove(f):

destination_ads_phones = open(destinations.get('ads_phones'), 'a')
destination_ads_phones.write(LOCK_TABLE_PHONES)

phone_row = ''
parsed_row = ''
count = 0
insert_count_additional_phones = 0
# Add additional phone numbers to results file.
for row in source_additional_phone:
  id = row.split(',')[0]
  phone_numbers_text = row.split(',')[1]
  phone_numbers_list = phone_numbers_text.split(':')
  for phone in phone_numbers_list:
    insert_count_additional_phones += 1
    parsed_phone = ''.join(phone.split('-'))
    if insert_count_additional_phones == MAX_INSERT_COUNT or count == TOTAL_RECORDS_COUNT_ADDITIONAL_PHONES:
      destination_ads_phones.write('(' + id + ', "' + parsed_phone.split('\n')[0] + '");')
    elif insert_count_additional_phones == 1:
      destination_ads_phones.write(INSERT_INTO_ADS_PHONES + '(' + id + ', "' + parsed_phone.split('\n')[0] + '"),')
    else:
      destination_ads_phones.write('(' + id + ', "' + parsed_phone.split('\n')[0] + '"),')
    if insert_count_additional_phones == MAX_INSERT_COUNT:
      insert_count_additional_phones = 0
  count += 1

destination_ads_phones.write("\nUNLOCK TABLES;")

# Merge all files.
# p = subprocess.Popen('awk \'{print}\' ' + destinations['ads'] + ' > ' + destinations['results'], shell=True)
# p.wait()
# p = subprocess.Popen('awk \'{print}\' ' + destinations['ads_keywords'] + ' >> ' + destinations['results'], shell=True)
# p.wait()
# p = subprocess.Popen('awk \'{print}\' ' + destinations['ads_phones'] + ' >> ' + destinations['results'], shell=True)
# p.wait()
# p = subprocess.Popen('awk \'{print}\' ' + destinations['ads_images'] + ' >> ' + destinations['results'], shell=True)
# p.wait()
# p = subprocess.Popen('awk \'{print}\' ' + destinations['ads_emails'] + ' >> ' + destinations['results'], shell=True)
# p.wait()
# p = subprocess.Popen('awk \'{print}\' ' + destinations['ads_misc'] + ' >> ' + destinations['results'], shell=True)
# p.wait()

# os.system('rm -rf ' + destinations['ads'])
# os.system('rm -rf ' + destinations['ads_keywords'])
# os.system('rm -rf ' + destinations['ads_phones'])
# os.system('rm -rf ' + destinations['ads_images'])
# os.system('rm -rf ' + destinations['ads_emails'])
# os.system('rm -rf ' + destinations['ads_misc'])
