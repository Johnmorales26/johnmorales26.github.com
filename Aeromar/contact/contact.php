<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://fonts.cdnfonts.com/css/monument-extended" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <link href="./styles_contact.css" rel="stylesheet">
    <title>Document</title>
</head>

<body>
    <h1>
        Contacto
    </h1>

    <img src="../Muestras/1.png" width="400" height="100">
    <a href="../consulta/consulta.php" class="button1">
        Destinos
    </a>
    <a href="../servicios/servicios.php" class="button1">
        Servicios
    </a>

   <section>
      <div class="container">
         <div class="content">
            <div class="form-check">
              <label class="form-check-label">
                <!-- <input type="checkbox" class="form-check-input" name="" id="" value="checkedValue" checked> -->
                              
            </div>
            <form>
               <input type="text" placeholder="name" name="name" required="">
               <input type="email" placeholder="email" name="email" required="">
               <input type="text" placeholder="asunto" name="asunto" required="">
               <textarea placeholder="mensaje" name="msg"></textarea>
               <input type="submit" >
            </form>   
            <?php
               include("correo.php");
            ?>
         </div>
      </div>
   </section>
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
</body>
<script src="../scripts/cursor.js"></script>
</html>