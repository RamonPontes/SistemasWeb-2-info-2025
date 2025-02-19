<?php
    $ano=isset($_POST["ano"])?$_POST["ano"]:0;

    $messes=$ano*12;
?>
<html>
<head>
    <title>Calculadora messes</title>
</head>
<body>
    <form action="index.php" method="post">
        <Label for="ano">Digite o ano</Label>
        <input type="text" name="ano" id="ano">

        <input type="submit" value="Calcular">
    </form>
    <?php
        echo("<p>A quantidade de messes é $messes</p>");
    ?>
</body>
</html>