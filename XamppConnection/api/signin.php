<?php

    $user = $_POST["user"];
    $password = $_POST["password"];
    $con = mysqli_connect("localhost", "root", "", "users");
    
    $query = "SELECT * FROM login WHERE user = '{$user}'";
    $temp = mysqli_query($con, $query);
    if ($temp){
        if (mysqli_num_rows($temp) > 0){
            $assoc = mysqli_fetch_assoc($temp);
            if ($password == $assoc["pass"]){
                echo "successfully logged in";
            }
        }
        else{
            echo "not registered";
        }
    }
    else{
        echo "failed";
    }
    

?>