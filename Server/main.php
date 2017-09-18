<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST')
	{
		foreach ($_POST as $key => $value) {

    			//echo $key ;
		}
		$answer=$key;


		list($t, $motion) = explode('^', $answer);






		
		if($rs === false)
		{
			trigger_error('Wrong SQL: ' . $sqli . ' Error: ' . $conn->error, E_USER_ERROR);
		}
		else
		{

			if($motion=="forward"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 6);
				fclose($myfile);
			}

			if($motion=="backward"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 7);
				fclose($myfile);
			}

			if($motion=="left"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 3);
				fclose($myfile);
			}

			if($motion=="right"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 8);
				fclose($myfile);
			}

			if($motion=="kill"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 2);
				fclose($myfile);

			}

			if($motion=="sit"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 9);
				fclose($myfile);
			}

			if($motion=="sitrelax"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 10);
				fclose($myfile);
			}

			if($motion=="crouch"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 1);
				fclose($myfile);
			}

			if($motion=="standinit"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 13);
				fclose($myfile);
			}

			if($motion=="standzero"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 14);
				fclose($myfile);
			}

			if($motion=="stand"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 12);
				fclose($myfile);
			}

			if($motion=="lyingbelly"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 5);
				fclose($myfile);
			}

			if($motion=="lyingback"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 4);
				fclose($myfile);
			}

			if($motion=="camera"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 16);
				fclose($myfile);
			}
			if($motion=="auto"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 17);
				fclose($myfile);
			}
			if($motion=="off"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 18);
				fclose($myfile);
			}
			if($motion=="about"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 19);
				fclose($myfile);
			}
			if($t=="text"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/text.txt", "w") or die("Unable to open file!");
				fwrite($myfile, $motion);
				fclose($myfile);
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 20);
				fclose($myfile);
			}

			if($motion=="sleep"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 11);
				fclose($myfile);
			}

			if($motion=="wake"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 15);
				fclose($myfile);
			}
			if($motion=="rec"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 21);
				fclose($myfile);
			}
			if($motion=="play"){
				$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
				fwrite($myfile, 22);
				fclose($myfile);
			}






		}

	}





?>

