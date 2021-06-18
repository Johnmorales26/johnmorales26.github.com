<?php
include('db.php');
$users=$_POST['users'];
$password=$_POST['password'];
session_start();
$_SESSION['users']=$users;

$conexion=mysqli_connect("localhost","root","","aeromar");

$consulta="SELECT*FROM usuarios where users='$users' and password='$password'";
$resultado=mysqli_query($conexion,$consulta);

$filas=mysqli_num_rows($resultado);

if($filas){
    header("location:prueba.php");
}else{
    ?>
    <?php
    header("location:errors/error.php");
    ?>
    <?php
}
mysqli_free_result($resultado);
mysqli_close($conexion);