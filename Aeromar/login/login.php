<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,
    initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>INICIA SESIÓN</title>
    <link href="http://fonts.cdnfonts.com/css/monument-extended" rel="stylesheet">
    <link rel="shortcut icon" href="../Muestras/LOGO.ico" type="image/x-icon"> 
    <link rel="stylesheet" href="styles.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
  </head>
  <body>

    <img src="../Muestras/1.png" width="400" height="100">
    <a href="../destinos/destinos.php" class="button1">
      Destinos
  </a>
  <a href="../servicios/servicios.php" class="button1">
      Servicios
  </a>
  <a href="#" class="button1">
      Contacto
  </a>

  <a href="javascript:window.history.back();" class="return">
    Atras
  </a>

  <div class="wrapper">
      <div class="icon facebook">
         <div class="tooltip">
            Facebook
         </div>
         <span><i class="fab fa-facebook-f"></i></span>
      </div>
      <div class="icon twitter">
         <div class="tooltip">
            Twitter
         </div>
         <span><i class="fab fa-twitter"></i></span>
      </div>
      <div class="icon instagram">
         <div class="tooltip">
            Instagram
         </div>
         <span><i class="fab fa-instagram"></i></span>
      </div>
      <div class="icon github">
         <div class="tooltip">
            Github
         </div>
         <span><i class="fab fa-github"></i></span>
      </div>
      <div class="icon youtube">
         <div class="tooltip">
            YouTube
         </div>
         <span><i class="fab fa-youtube"></i></span>
      </div>
   </div>


    <div class="login-box"><h1>INICIA SESIÓN</h1>
      <h2>¡Y RESERVA TU VUELO!</h2>
      <form action="validation.php" method="post">
       
        <!-- EMAIL INPUT -->
        <label for="email">USUARIO</label>
        <input type="text" placeholder="" name="users">
        <!-- PASSWORD INPUT -->
        <label for="password">CONTRASEÑA</label>
        <input type="password" placeholder="" name="password">
        <input type="submit" value="INICIAR SESION"><br>
        
      </form>
    </div>

    <img class="mail" src="../Muestras/Mail.png" width="50" height="40">
    <img class="lock" src="../Muestras/lock.png" width="70" height="70">

  </body>
  <script src="../scripts/cursor.js"></script>
</html>