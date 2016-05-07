def runProgram():
    print "msgtype\t|side\t|exchange\t|condition\t|size\t|time\t\t|symbol\t|price"
    with open("./trades.bin") as f:
        for line in f.readlines():
            packet = line.split(" ")
            if len(packet) < 8:
                continue
            
            msgtype = packet[0][0]
            side = packet[0][1]
            exchange = packet[0][2]
            condition = packet[0][3]
            size = int(packet[1], 16)
            time = int(packet[2] + packet[3], 16)
            symbol = packet[4] + packet[5]
            price = packet[6] + packet[7]
            print msgtype + "\t|" + side + "\t|" + exchange + "\t|" + condition + "\t|" + str(size) + "\t|" + str(time) + "\t\t\t|" + symbol + "\t|" + price.split("\n")[0]
            
            

if __name__ == "__main__":
    runProgram()