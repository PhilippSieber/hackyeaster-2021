<?php
    header("Content-Type: text/plain");
    if (!isset($_POST["url"])) {
        echo "You must provide a URL";
        exit();
    }
    if (strpos($_POST["url"], ' ') !== false) {
        echo "nice try - www.youtube.com/watch?v=a4eav7dFvc8";
        exit();
    }
    if (strpos($_POST["url"], ';') !== false) {
        echo "nice try - www.youtube.com/watch?v=MF283pORG2E";
        exit();
    }
    echo shell_exec("nc -zv " . $_POST["url"] . " 80 2>&1");
?>