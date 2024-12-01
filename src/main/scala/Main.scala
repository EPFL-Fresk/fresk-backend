import upickle.default.*
import models.Tables
import slick.jdbc.JdbcBackend.Database

val asso = Seq(Tables.AssociationsRow(0, "FriteNRepasse", Some("repare"), Some("repare"), Some("repare"), Some("repare"), Some(12)))

object Tables:
  case class AssociationsRow(
    id: Int, 
    name: String, 
    subtitle: Option[String] = None, 
    description: Option[String] = None, 
    logo: Option[String] = None, 
    banner: Option[String] = None, 
    activeMembers: Option[Int] = None) derives ReadWriter
  

object Main extends cask.MainRoutes:
  override def host= "0.0.0.0"
  override def port= 9090

  @cask.get("/associations")
  def associations() = 
    val db = Database.forConfig("postgres")
    db.run(models.Tables.Associations)

    cask.Response(
      data=write(Map("associations" -> asso)),
      headers=Seq(("Access-Control-Allow-Origin", "*"))
    )

  @cask.post("/associations")
  def uploadAssociation(request: cask.Request): String =
    try
      // val association: Association = read[Association](request.text())
      // println(s"Received JSON: ${association.name}")

      // assos = Seq(association) ++ assos

      // s"Association '${association.name}' successfully added with ${association.committee.size} committee members!"
      "hello"
    catch
      case e: Exception => s"Failed to create association: ${e.getMessage}"

  initialize()
