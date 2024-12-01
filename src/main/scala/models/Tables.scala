package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends Tables {
  val profile: slick.jdbc.JdbcProfile = slick.jdbc.PostgresProfile
}

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for
  // tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Associations.schema ++ CommitteePosition.schema ++ Events.schema ++ People.schema

  /** Entity class storing rows of table Associations
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Length(255,true)
   *  @param subtitle Database column subtitle SqlType(varchar), Length(255,true), Default(None)
   *  @param description Database column description SqlType(text), Default(None)
   *  @param logo Database column logo SqlType(text), Default(None)
   *  @param banner Database column banner SqlType(text), Default(None)
   *  @param activeMembers Database column active_members SqlType(int4), Default(None) */
  case class AssociationsRow(id: Int, name: String, subtitle: Option[String] = None, description: Option[String] = None, logo: Option[String] = None, banner: Option[String] = None, activeMembers: Option[Int] = None)
  /** GetResult implicit for fetching AssociationsRow objects using plain SQL queries */
  implicit def GetResultAssociationsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[Option[Int]]): GR[AssociationsRow] = GR{
    prs => import prs._
    (AssociationsRow.apply _).tupled((<<[Int], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table associations. Objects of this class serve as prototypes for rows in queries. */
  class Associations(_tableTag: Tag) extends profile.api.Table[AssociationsRow](_tableTag, "associations") {
    def * = ((id, name, subtitle, description, logo, banner, activeMembers)).mapTo[AssociationsRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), subtitle, description, logo, banner, activeMembers)).shaped.<>({r=>import r._; _1.map(_=> (AssociationsRow.apply _).tupled((_1.get, _2.get, _3, _4, _5, _6, _7)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column subtitle SqlType(varchar), Length(255,true), Default(None) */
    val subtitle: Rep[Option[String]] = column[Option[String]]("subtitle", O.Length(255,varying=true), O.Default(None))
    /** Database column description SqlType(text), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column logo SqlType(text), Default(None) */
    val logo: Rep[Option[String]] = column[Option[String]]("logo", O.Default(None))
    /** Database column banner SqlType(text), Default(None) */
    val banner: Rep[Option[String]] = column[Option[String]]("banner", O.Default(None))
    /** Database column active_members SqlType(int4), Default(None) */
    val activeMembers: Rep[Option[Int]] = column[Option[Int]]("active_members", O.Default(None))
  }
  /** Collection-like TableQuery object for table Associations */
  lazy val Associations = new TableQuery(tag => new Associations(tag))

  /** Entity class storing rows of table CommitteePosition
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param associationId Database column association_id SqlType(int4)
   *  @param personId Database column person_id SqlType(int4)
   *  @param role Database column role SqlType(varchar), Length(255,true)
   *  @param description Database column description SqlType(text), Default(None) */
  case class CommitteePositionRow(id: Int, associationId: Int, personId: Int, role: String, description: Option[String] = None)
  /** GetResult implicit for fetching CommitteePositionRow objects using plain SQL queries */
  implicit def GetResultCommitteePositionRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]]): GR[CommitteePositionRow] = GR{
    prs => import prs._
    (CommitteePositionRow.apply _).tupled((<<[Int], <<[Int], <<[Int], <<[String], <<?[String]))
  }
  /** Table description of table committee_position. Objects of this class serve as prototypes for rows in queries. */
  class CommitteePosition(_tableTag: Tag) extends profile.api.Table[CommitteePositionRow](_tableTag, "committee_position") {
    def * = ((id, associationId, personId, role, description)).mapTo[CommitteePositionRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(associationId), Rep.Some(personId), Rep.Some(role), description)).shaped.<>({r=>import r._; _1.map(_=> (CommitteePositionRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column association_id SqlType(int4) */
    val associationId: Rep[Int] = column[Int]("association_id")
    /** Database column person_id SqlType(int4) */
    val personId: Rep[Int] = column[Int]("person_id")
    /** Database column role SqlType(varchar), Length(255,true) */
    val role: Rep[String] = column[String]("role", O.Length(255,varying=true))
    /** Database column description SqlType(text), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))

    /** Foreign key referencing Associations (database name committee_position_association_id_fkey) */
    lazy val associationsFk = foreignKey("committee_position_association_id_fkey", associationId, Associations)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing People (database name committee_position_person_id_fkey) */
    lazy val peopleFk = foreignKey("committee_position_person_id_fkey", personId, People)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)

    /** Uniqueness Index over (associationId,personId) (database name committee_position_association_id_person_id_key) */
    val index1 = index("committee_position_association_id_person_id_key", (associationId, personId), unique=true)
  }
  /** Collection-like TableQuery object for table CommitteePosition */
  lazy val CommitteePosition = new TableQuery(tag => new CommitteePosition(tag))

  /** Entity class storing rows of table Events
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param dateTime Database column date_time SqlType(timestamp)
   *  @param location Database column location SqlType(varchar), Length(255,true)
   *  @param description Database column description SqlType(text)
   *  @param image Database column image SqlType(text), Default(None)
   *  @param duration Database column duration SqlType(interval), Length(49,false), Default(None)
   *  @param associationId Database column association_id SqlType(int4) */
  case class EventsRow(id: Int, dateTime: java.sql.Timestamp, location: String, description: String, image: Option[String] = None, duration: Option[String] = None, associationId: Int)
  /** GetResult implicit for fetching EventsRow objects using plain SQL queries */
  implicit def GetResultEventsRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp], e2: GR[String], e3: GR[Option[String]]): GR[EventsRow] = GR{
    prs => import prs._
    (EventsRow.apply _).tupled((<<[Int], <<[java.sql.Timestamp], <<[String], <<[String], <<?[String], <<?[String], <<[Int]))
  }
  /** Table description of table events. Objects of this class serve as prototypes for rows in queries. */
  class Events(_tableTag: Tag) extends profile.api.Table[EventsRow](_tableTag, "events") {
    def * = ((id, dateTime, location, description, image, duration, associationId)).mapTo[EventsRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(dateTime), Rep.Some(location), Rep.Some(description), image, duration, Rep.Some(associationId))).shaped.<>({r=>import r._; _1.map(_=> (EventsRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7.get)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column date_time SqlType(timestamp) */
    val dateTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("date_time")
    /** Database column location SqlType(varchar), Length(255,true) */
    val location: Rep[String] = column[String]("location", O.Length(255,varying=true))
    /** Database column description SqlType(text) */
    val description: Rep[String] = column[String]("description")
    /** Database column image SqlType(text), Default(None) */
    val image: Rep[Option[String]] = column[Option[String]]("image", O.Default(None))
    /** Database column duration SqlType(interval), Length(49,false), Default(None) */
    val duration: Rep[Option[String]] = column[Option[String]]("duration", O.Length(49,varying=false), O.Default(None))
    /** Database column association_id SqlType(int4) */
    val associationId: Rep[Int] = column[Int]("association_id")

    /** Foreign key referencing Associations (database name events_association_id_fkey) */
    lazy val associationsFk = foreignKey("events_association_id_fkey", associationId, Associations)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table Events */
  lazy val Events = new TableQuery(tag => new Events(tag))

  /** Entity class storing rows of table People
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Length(255,true)
   *  @param telegramHandle Database column telegram_handle SqlType(varchar), Length(255,true), Default(None)
   *  @param email Database column email SqlType(varchar), Length(255,true)
   *  @param associationId Database column association_id SqlType(int4) */
  case class PeopleRow(id: Int, name: String, telegramHandle: Option[String] = None, email: String, associationId: Int)
  /** GetResult implicit for fetching PeopleRow objects using plain SQL queries */
  implicit def GetResultPeopleRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]]): GR[PeopleRow] = GR{
    prs => import prs._
    (PeopleRow.apply _).tupled((<<[Int], <<[String], <<?[String], <<[String], <<[Int]))
  }
  /** Table description of table people. Objects of this class serve as prototypes for rows in queries. */
  class People(_tableTag: Tag) extends profile.api.Table[PeopleRow](_tableTag, "people") {
    def * = ((id, name, telegramHandle, email, associationId)).mapTo[PeopleRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), telegramHandle, Rep.Some(email), Rep.Some(associationId))).shaped.<>({r=>import r._; _1.map(_=> (PeopleRow.apply _).tupled((_1.get, _2.get, _3, _4.get, _5.get)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column telegram_handle SqlType(varchar), Length(255,true), Default(None) */
    val telegramHandle: Rep[Option[String]] = column[Option[String]]("telegram_handle", O.Length(255,varying=true), O.Default(None))
    /** Database column email SqlType(varchar), Length(255,true) */
    val email: Rep[String] = column[String]("email", O.Length(255,varying=true))
    /** Database column association_id SqlType(int4) */
    val associationId: Rep[Int] = column[Int]("association_id")

    /** Foreign key referencing Associations (database name people_association_id_fkey) */
    lazy val associationsFk = foreignKey("people_association_id_fkey", associationId, Associations)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table People */
  lazy val People = new TableQuery(tag => new People(tag))
}
