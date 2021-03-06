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
    ## Set NAO in stiffness On
    StiffnessOn(motion)
    ## Enable arms control by move algorithm
    motion.setMoveArmsEnabled(True, True)
    ## FOOT CONTACT PROTECTION
    motion.setMotionConfig([["ENABLE_FOOT_CONTACT_PROTECTION", True]])
    ## get robot position before move


    tts.setParameter("doubleVoice", 1)
    tts.setParameter("doubleVoiceLevel", 0)
    tts.setParameter("doubleVoiceTimeShift", 0.1)
    tts.setParameter("pitchShift", 1.1)
    tts.say("TURNING RIGHT!")

    #TARGET VELOCITY
    X = 0
    Y = 0
    Theta = -math.pi/3.0                 #math.pi/2.0 90 #math.pi/3 60 #math.pi/4 45
    Frequency=0
    motion.post.moveTo(X, Y, Theta)
    # wait that the move process start running
    time.sleep(0.1)
    footSteps1 = motion.getFootSteps()
    # Second call of move API
    motion.post.moveTo(X, Y, Theta)
    # get the second foot steps vector
    footSteps2 = motion.getFootSteps()
    # here we wait until the move process is over
    motion.waitUntilMoveIsFinished()
    # then we get the final robot position













def StiffnessOn(proxy):
    # We use the "Body" name to signify the collection of all joints
    pNames = "Body"
    pStiffnessLists = 1.0
    pTimeLists = 1.0
    proxy.stiffnessInterpolation(pNames, pStiffnessLists, pTimeLists)



def LArmInit():
    motion.setAngles('LShoulderPitch', 0, 0.2)
    motion.setAngles('LShoulderRoll', 0, 0.2)
    motion.setAngles('LElbowYaw', 0, 0.2)
    motion.setAngles('LElbowRoll', 0, 0.2)
    motion.setAngles('LWristYaw', 0, 0.2)
def RArmInit():
    motion.setAngles('RShoulderPitch', 0, 0.2)
    motion.setAngles('RShoulderRoll', 0, 0.2)
    motion.setAngles('RElbowYaw', 0, 0.2)
    motion.setAngles('RElbowRoll', 0, 0.2)
    motion.setAngles('RWristYaw', 0, 0.2)
def LArmUp():
    motion.setAngles('LShoulderPitch', 0.7, 0.2)
    motion.setAngles('LShoulderRoll', 0.3, 0.2)
    motion.setAngles('LElbowYaw', -1.5, 0.2)
    motion.setAngles('LElbowRoll', -0.5, 0.2)
    motion.setAngles('LWristYaw', -1.7, 0.2)
def RArmUp():
    motion.setAngles('RShoulderPitch', 0.7, 0.2)
    motion.setAngles('RShoulderRoll', -0.3, 0.2)
    motion.setAngles('RElbowYaw', 1.5, 0.2)
    motion.setAngles('RElbowRoll', 0.5, 0.2)
    motion.setAngles('RWristYaw', 1.7, 0.2)
def ArmUp2():
    motion.rest()
    motion.wakeUp()
    motion.setAngles('RShoulderPitch', 0.7, 0.2)
    motion.setAngles('RWristYaw', 1.5, 0.2)
    motion.setAngles('LShoulderPitch', 0.7, 0.2)
    motion.setAngles('LWristYaw', -1.5, 0.2)
def LArmMoveInit():
    motion.setAngles('LShoulderPitch', 1, 0.2)
    motion.setAngles('LShoulderRoll', 0.3, 0.2)
    motion.setAngles('LElbowYaw', -1.3, 0.2)
    motion.setAngles('LElbowRoll', -0.5, 0.2)
    motion.setAngles('LWristYaw', 0, 0.2)
def RArmMoveInit():
    motion.setAngles('RShoulderPitch', 1, 0.2)
    motion.setAngles('RShoulderRoll', -0.3, 0.2)
    motion.setAngles('RElbowYaw', 1.3, 0.2)
    motion.setAngles('RElbowRoll', 0.5, 0.2)
    motion.setAngles('RWristYaw', 0, 0.2)
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
        print "Usage python alrobotposture.py robotIP "
    else:
        robotIp = sys.argv[1]
    main(robotIp)
