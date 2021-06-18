<?php
    $conexion=mysqli_connect("localhost","root","","aeromar");

    if (isset($_POST['validate'])) {
        if (strlen($_POST['users']) >= 1 &&
            strlen($_POST['mail']) >= 1 &&
            strlen($_POST['password']) >= 1) {
                $users = trim($_POST['users']);
                $mail = trim($_POST['mail']);
                $password = trim($_POST['password']);
                $consulta = "INSERT INTO usuarios(users, mail, password) VALUES ('$users','$mail','$password')";
                $resultado = mysqli_query($conexion,$consulta);

                if ($resultado) {
                    header("location:correct/correct.php");
                }else{
                    ?>
                    <?php
                    header("location:errors/error.php");
                    ?>
                    <?php
                }
        }
    }
?>