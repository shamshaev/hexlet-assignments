@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
<head>
    <meta charset="utf-8" />
    <title>Хекслет</title>
</head>
<body>
<h3>${page.getHeader()}</h3>
@if(page.getUsers().isEmpty())
    <p>Пока не добавлено ни одного пользователя</p>
@else
    @for(var user : page.getUsers())
        <div>
            <p><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></p>
        </div>
    @endfor
@endif
</body>
</html>