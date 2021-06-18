<?php

if (isset($_POST['enviar']))
{
    if (!empy($_POST['name'])) && !empy($_POST['asunto']) && !empy($_POST['msg']) && !
    empy($_POST['mail'])
    {
        $name = $_POST['name']:
        $asunto = $_POST['asunto']:
        $msg = $_POST['msgame']:
        $mail = $_POST['mail']:
        $header = "From: 191130300@gamadero.tecnm.mx" . "\r\n";
        $header.= "Reply-To: 191130300@gamadero.tecnm.mx" . "\r\n";
        // $header.= "X-Mailer: PHP/" . phpversion();
        // $mail = mail($mail, $asunto, $msg, $header);
        $header ="X-Mailer: PHP/" . phpversion();
        $mail = @mail($email,$asunto,$msg,$header);
        if ($mail)
        {
            echo "<h4>¡Mail enviado exitosamente!<h4>";
        }
    }
}
// tics04@gamadero.tecnm.mx