@template.layout.page(
    content = @`
        <div style="text-align: center; height: 600px; overflow: auto;">
            <h2>Welcome to Hexlet</h2>
            <div style="padding: 50px;">
                <a href="${exercise.util.NamedRoutes.postsPath()}">к постам</a>
            </div>
        </div>
    `
)
