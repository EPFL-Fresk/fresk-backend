
object CodeGenerator extends App:
  slick.codegen.SourceCodeGenerator.run(
    "slick.jdbc.PostgresProfile",
    "org.postgresql.Driver",
    "jdbc:postgresql://localhost/fresk?user=dbuser&password=1234",
    "./src/main/scala/",
    "models", None, None, true, false
  )

