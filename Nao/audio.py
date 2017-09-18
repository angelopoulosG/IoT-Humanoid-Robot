import argparse
from naoqi import ALProxy
import time

tts = audio = record = aup = None 
robot_IP = "127.0.0.1"
robot_PORT = 9559



#photoCaptureProxy.setResolution(0)
#photoCaptureProxy.setPictureFormat("jpg")
#photoCaptureProxy.takePictures(1, "/var/volatile/", "image")


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


# ----------> recording <----------


tts.setParameter("doubleVoice", 1)
tts.setParameter("doubleVoiceLevel", 0)
tts.setParameter("doubleVoiceTimeShift", 0.1)
tts.setParameter("pitchShift", 1.1)
tts.say("speak now please")




record_path = '/home/nao/record.wav'
record.startMicrophonesRecording("/var/volatile/test.wav", 'wav', 16000, (0,0,1,0))
time.sleep(3)
record.stopMicrophonesRecording()

tts.say("Recording is. over.")

time.sleep(1)



	

