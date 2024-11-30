import cask.main.Routes
import upickle.default.*
import models._
import _root_.models.models.DummyData

object Main extends cask.MainRoutes:
  override def host= "0.0.0.0"
  override def port= 9090

  var assos: Seq[Association] = DummyData.associations

  @cask.get("/associations")
  def associations(): String = 
    write(Map("associations" -> assos))

  @cask.post("/associations")
  def uploadAssociation(request: cask.Request): String =
    try
      val association: Association = read[Association](request.text())
      println(s"Received JSON: ${association.name}")

      assos = Seq(association) ++ assos

      s"Association '${association.name}' successfully added with ${association.committee.size} committee members!"
    catch
      case e: Exception => s"Failed to create association: ${e.getMessage}"

  initialize()
