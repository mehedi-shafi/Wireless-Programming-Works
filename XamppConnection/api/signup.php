<?php 

    $con = mysqli_connect("localhost", "root", "", "users");
    
    $user = $_POST["user"];
    $pass = $_POST["password"];
    $email = $_POST["email"];
    $name = $_POST["name"];

    //if the username exists
    $query = "SELECT * FROM login WHERE user = '{$user}'";
    $temp = mysqli_query ($con, $query);
    if (mysqli_num_rows($temp) > 0){
        echo "exists";
    }
    else{
        $query = "INSERT INTO login(user, pass, email, name) VALUES('{$user}', '{$pass}', '{$email}', '{$name}')";
        $temp = mysqli_query ($con, $query);
        if($temp){
            echo "Successfully Created";
        }
    }
?>