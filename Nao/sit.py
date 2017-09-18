import sys
from naoqi import ALProxy
import time
import almath
import math
import argparse



motion = None
HAS_PYLAB = True




def main(robotIP):
    global motion

    PORT = 9559
#===================================================================
    try:
        motion = ALProxy("ALMotion", robotIP, PORT)
    except Exception, a:
        print "Could not create proxy to ALMotion"
        print "Error was: ", a
#===================================================================
    try:
        tts = ALProxy("ALTextToSpeech", robotIP, PORT)
    except Exception, b:
        print "Could not create proxy to ALTextToSpeech"
        print "Error was: ", b
#===================================================================
    try:
        postureProxy = ALProxy("ALRobotPosture", robotIP, PORT)
    except Exception, c:
        print "Could not create proxy to ALRobotPosture"
        print "Error was: ", c
#===================================================================






    ## Wake up robot
    motion.wakeUp()

    tts.setParameter("doubleVoice", 1)
    tts.setParameter("doubleVoiceLevel", 0)
    tts.setParameter("doubleVoiceTimeShift", 0.1)
    tts.setParameter("pitchShift", 1.1)
    tts.say("SIT!")
    postureProxy.goToPosture("Sit", 1.0)






def Postures():
#Here is the list of the Predefined Postures: Crouch, LyingBack, LyingBelly, Sit, SitRelax, Stand, StandInit, StandZero.
    postureProxy.goToPosture("Crouch", 1.0)
    postureProxy.goToPosture("LyingBack", 1.0)
    postureProxy.goToPosture("LyingBelly", 1.0)
    postureProxy.goToPosture("Sit", 1.0)
    postureProxy.goToPosture("SitRelax", 1.0)
    postureProxy.goToPosture("Stand", 1.0)
    postureProxy.goToPosture("StandInit", 1.0)
    postureProxy.goToPosture("StandZero", 2.0)
def AnoigmaXeriou():
    motion.openHand("LHand")
    motion.openHand("RHand")
def KleisimoXeriou():
    motion.closeHand("LHand")
    motion.closeHand("RHand")













if __name__ == "__main__":


    robotIp = "127.0.0.1"



    if len(sys.argv) <= 1:
        print "Usage python alrobotposture.py robotIP"
    else:
        robotIp = sys.argv[1]
    main(robotIp)
