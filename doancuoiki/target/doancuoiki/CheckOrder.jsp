<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
  <link href="css/login.css" rel="stylesheet" type="text/css"/>
  <title>Login Form</title>
</head>
<body>
<div class="container">
  <form class="form-check" action="orderConfirmation" method="post">
    <h2>Xac Thuc Don Hang </h2>

    <div class="form-group">
      <label for="privatekey">Vui Long Nhap PrivateKey:</label>
      <input type="hidden" name="cid" id="cid" value="${cid}" class="form-control">
      <input type="text" name="privatekey" id="privatekey" class="form-control">
    </div>
    <input type="submit" value="Xac Thuc" class="btn btn-primary float-right mr-5" id="sm_order">
  </form>
</div>

</body>
</html>
