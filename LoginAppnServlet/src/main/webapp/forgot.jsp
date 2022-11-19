<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<title>ForgotPasswordPage</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h1 style="text-align: center; color: blue">Forgot Password Page</h1>

			</div>
			<div class="card-body">
				<form action="./forgot" method="post" class="form-control">
					<div class="form-control">
						<input type="text" name="uname" placeholder="Enter UserName"
							class="form-control" />
					</div>

					<div class="form-control">
						<select name="type">
							<option selected>Open this select menu</option>
							<option value="admin">Admin</option>
							<option value="user">User</option>
						</select>
					</div>
					<div>
						<input type="submit" value="GetPassword" class="btn btn-primary" />

					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>