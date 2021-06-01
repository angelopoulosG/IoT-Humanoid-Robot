# An Internet of Things Humanoid Robot Teleoperated by an Open Source Android Application
## Abstract 

The Internet of Things (IoT) is a system of interrelated computing devices, mechanical and digital machines, objects, animals or people that are provided with unique identifiers and the ability to transfer data over a network without requiring human-to-human interaction. Nowadays the use of IoT in industrial robots is very popular contrary to humanoid robots. There have been a few attempts that combine IoT with humanoid robots but they have limited features. This paper proposes a novel open source platform Android application for controlling a humanoid robot, with more features than other research projects, in remote areas either behind NAT (Network Address Translation) or without it. The user can view what the robot is seeing through the Android application and can also move it. Additionally, our system has the ability to deliver real-time audio through our application. We envision that our proposed system is not only an attractive solution for many telerobotic applications but also an extensive educational tool in special needs education.

Published in: [2017 Panhellenic Conference on Electronics and Telecommunications (PACET)](https://ieeexplore.ieee.org/xpl/conhome/8245950/proceeding)

DOI: [10.1109/PACET.2017.8259978](https://doi.org/10.1109/PACET.2017.8259978)

## System Architecture
<img src="/images/system_architecture.png" width="600">

## Prerequisites 

### Python 3 (On your computer/server)

With the following libraries installed:

*   SpeechRecognition, a library for performing speech recognition.

```console
pip3 install SpeechRecognition
```

### Nao Robot
Pepper is a semi-humanoid robot manufactured by SoftBank Robotics (formerly Aldebaran Robotics).

## How to run it
*   First, download all the code from the folder **Server** to your computer/server.
*   Finally, Enable the "Brain":

```console
python3 thebrain.py
```

*   After enabling the server, SSH onto the robot and download all the code from the folder **Pepper**.
*   Finally, Enable Pepper:

```console
python ethical_pepper.py
```


<img src="/images/Dilemmas/case_no1.png" width="650">

## Authors

[**Georgios Angelopoulos**](https://www.linkedin.com/in/george-angelopoulos/)

[**Georgios Kalampokis**](https://www.linkedin.com/in/george-angelopoulos/)

[**Minas Dasygenis**](https://www.linkedin.com/in/george-angelopoulos/)
