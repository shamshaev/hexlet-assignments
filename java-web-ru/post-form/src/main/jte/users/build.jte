@template.layout.page(
content = @`
    <form action="/users" method="post">
        <div>
            <label>
                Имя
                <input type="text" name="firstName" />
            </label>
        </div>
        <div>
            <label>
                Фамилия
                <input type="email" required name="lastName" />
            </label>
        </div>
        <div>
            <label>
                Email
                <input type="password" required name="email" />
            </label>
        </div>
        <div>
            <label>
                Пароль
                <input type="password" required name="password" />
            </label>
        </div>
        <input type="submit" value="Зарегистрировать" />
    </form>

`
)
