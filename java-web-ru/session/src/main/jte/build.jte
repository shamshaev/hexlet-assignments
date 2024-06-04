@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
content = @`
    <div style="text-align: center; margin-top: 100px;">
        @if(page.getError() != null)
            <span style="color: red;">${page.getError()}</span>
        @endif
        <form style="padding-top: 20px;" action="${NamedRoutes.loginPath()}" method="post">
            <label>
                Имя
                <input type="text" required name="name" value="${page.getName()}" />
            </label>
            <label>
                Пароль
                <input type="password" required name="password" />
            </label>
            <input type="submit" value="Submit"/>
        </form>
    </div>
`
)

