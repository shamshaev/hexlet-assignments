@import exercise.util.NamedRoutes
@import exercise.dto.MainPage
@param MainPage page

@template.layout.page(
content = @`
    <div style="text-align: center; margin-top: 100px;">
        @if(page.getName() == null)
            <span><a href="${NamedRoutes.buildSessionPath()}">Войти</a></span>
        @else
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <span>${(String) page.getName()}</span>
                <input type="submit" value="Выйти" />
            </form>
        @endif
    </div>
`
)