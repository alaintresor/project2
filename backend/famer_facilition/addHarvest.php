<?php
include "connection.php";

$famerId = $_POST['farmerId'];
$harvest = $_POST['harvest'];
$quantity = $_POST['quantity'];
$price = $_POST['price'];
$date = date("d/m/Y");

$query = "INSERT INTO `harvest` (`id`, `farmerId`, `harvest_name`, `date`, `quantity`, `price`) VALUES (NULL, '$famerId', '$harvest', '$date', '$quantity', '$price');";
$done = mysqli_query($connect, "$query");
if ($done) {
    echo "Your harvest Added";
} else {
    echo "Error:" . mysqli_error($connect);
}
