<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php 
    $myName = "Servidor";
    $students = ["Ana", "Bruno", 15, true];

       foreach ($students as $item) {
        echo "<p>$item<p/>";
    }
    ?>
    
    <h5>Olá Servidor! <?php $myName ?></h5>

 
</body>
</html