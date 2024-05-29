@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <div style="text-align: left; margin-top: 240px; margin-left: 600px; font-size: 20px;">
        <p>id: ${page.getUser().getId()}</p>
        <p>name: ${page.getUser().getFirstName()} ${page.getUser().getLastName()}</p>
        <p>email: ${page.getUser().getEmail()}</p>
    </div>

`
)
