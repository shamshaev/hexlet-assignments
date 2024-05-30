@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <div style="text-align: center; height: 600px; overflow: auto;">
        <form action="/users" method="get">
            <input type="search" name="term" value="${page.getTerm()}" />
            <input type="submit" value="Search" />
        </form>
        @for(var user : page.getUsers())
            <div>
                <p style="font-size: 20;">
                    ${user.getId()} ${user.getFirstName()} ${user.getLastName()}
                </p>
            </div>
        @endfor
    </div>
`
)
