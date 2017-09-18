
#!/bin/sh





auto=0
valid=1
while [ 1 -eq 1 ]
do
action=`wget -q http://zafora.icte.uowm.gr/~ictest00577/status.txt -O-`


if [ ! -z "$action" ] ; then

case $action in
	0)
		sleep 1
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
	;;
	1)
		python crouch.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	2)
		python kill_him.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	3)
		python left.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	4)
		python lyingback.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	5)
		python lyingbelly.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	6)
		python move_forward.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	7)
		python move_backwards.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	8)
		python Right.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	9)
		python sit.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	10)
		python sitrelax.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	11)
		python sleep.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	12)
		python stand.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	13)
		python standinit.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	14)
		python standzero.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	15)
		python wake.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	16)
		python camera.py
		curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	17)
		auto=1
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	18)
		auto=0
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
	19)
		python about.py
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;
        20)
                python text.py
                if [ "$auto" == "$valid" ]; then
                        python camera.py
                        curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg'$
                fi
                #reset status
                curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
        ;;
	21)
                python audio.py
                curl -X POST -F 'fileup=@/var/volatile/test.wav' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload1.php
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php

	;;
	22)
                curl -o recording.wav http://zafora.icte.uowm.gr/~ictest00577/image_upload/recording/recording.wav
		python play_wav.py
                curl -X POST -F 'fileup=@/var/volatile/test.wav' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload1.php
		if [ "$auto" == "$valid" ]; then
			python camera.py
			curl -X POST -F 'fileToUpload=@/var/volatile/image.jpg' -F "submit=1" http://zafora.icte.uowm.gr/~ictest00577/image_upload/upload.php
		fi
		#reset status
		curl http://zafora.icte.uowm.gr/~ictest00577/reset.php
	;;            

		




esac
fi

done
