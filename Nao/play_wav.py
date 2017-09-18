import argparse
from naoqi import ALProxy
import time


tts = audio = record = aup = None 
robot_IP = "127.0.0.1"
robot_PORT = 9559





# Create a proxy to ALPhotoCapture
try:
  tts = ALProxy("ALTextToSpeech", robot_IP, robot_PORT)
except Exception, e:
  print "Error when creating ALTextToSpeech proxy:"
  print str(e)
  exit(1)



try:
  audio = ALProxy("ALAudioDevice", robot_IP, robot_PORT)
except Exception, b:
  print "Error when creating ALAudioDevice proxy:"
  print str(b)
  exit(1)

try:
  record = ALProxy("ALAudioRecorder", robot_IP, robot_PORT)
except Exception, c:
  print "Error when creating ALAudioRecorder proxy:"
  print str(c)
  exit(1)

try:
  aup = ALProxy("ALAudioPlayer", robot_IP, robot_PORT)
except Exception, d:
  print "Error when creating ALAudioPlayer proxy:"
  print str(d)
  exit(1)
	



fileID = aup.playFile("/var/persistent/home/nao/recording.wav", 0.7, 0)

