<?php

$myfile = fopen("/zstorage/home/ictest00577/public_html/status.txt", "w") or die("Unable to open file!");
fwrite($myfile, 0);
fclose($myfile);

?>
