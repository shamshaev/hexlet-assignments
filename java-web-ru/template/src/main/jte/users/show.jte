@import exercise.dto.users.UserPage
@param UserPage page

<main>
    <p>id: ${page.getUser().getId()}</p>
    <p>name: ${page.getUser().getFirstName()} ${page.getUser().getLastName()}</p>
    <p>email: ${page.getUser().getEmail()}</p>
</main>
