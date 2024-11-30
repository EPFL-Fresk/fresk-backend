package models

package models

object DummyData:
  val associations: List[Association] = List(
    Association(
      id = Some(1),
      name = "Tech Enthusiasts Club",
      subtitle = Some("Exploring the world of technology"),
      description = "A club for tech enthusiasts to meet, collaborate, and innovate.",
      logo = Some("https://example.com/logo-tech.png"),
      banner = Some("https://example.com/banner-tech.png"),
      activeMembers = Some(150),
      events = List(
        Event(
          id = Some(1),
          name = "Hackathon 2024",
          description = "A 24-hour coding competition.",
          location = "Tech Hub Building",
          startTime = "2024-12-15T09:00:00Z",
          duration = Some("24h"),
          image = Some("https://example.com/event-hackathon.png")
        )
      ),
      imageGallery = List("https://example.com/img1.png", "https://example.com/img2.png"),
      committee = List(
        Person(id = Some(1), name = "Alice Johnson", role = "President", email = "alice@example.com"),
        Person(id = Some(2), name = "Bob Smith", role = "Secretary", email = "bob@example.com")
      )
    ),
    Association(
      id = Some(2),
      name = "Art Lovers Association",
      subtitle = Some("Embracing creativity and art"),
      description = "An association dedicated to exploring and promoting art.",
      logo = Some("https://example.com/logo-art.png"),
      banner = Some("https://example.com/banner-art.png"),
      activeMembers = Some(90),
      events = List(
        Event(
          id = Some(2),
          name = "Art Expo 2024",
          description = "A day-long event showcasing local artists.",
          location = "Art Gallery Center",
          startTime = "2024-11-20T10:00:00Z",
          duration = Some("8h"),
          image = Some("https://example.com/event-artexpo.png")
        )
      ),
      imageGallery = List("https://example.com/art1.png", "https://example.com/art2.png"),
      committee = List(
        Person(id = Some(3), name = "Jane Doe", role = "President", email = "jane@example.com"),
        Person(id = Some(4), name = "John Artist", role = "Treasurer", email = "john@example.com")
      )
    ),
    Association(
      id = Some(3),
      name = "Bookworms Club",
      subtitle = Some("Sharing the joy of reading"),
      description = "A community for book lovers to read and discuss books together.",
      logo = Some("https://example.com/logo-books.png"),
      banner = Some("https://example.com/banner-books.png"),
      activeMembers = Some(120),
      events = List(
        Event(
          id = Some(3),
          name = "Monthly Book Club Meeting",
          description = "A monthly discussion on the chosen book.",
          location = "Library Room 3",
          startTime = "2024-10-25T18:00:00Z",
          duration = Some("2h"),
          image = None
        )
      ),
      imageGallery = List("https://example.com/book1.png", "https://example.com/book2.png"),
      committee = List(
        Person(id = Some(5), name = "Mary Reader", role = "Coordinator", email = "mary@example.com"),
        Person(id = Some(6), name = "Chris Writer", role = "Member", email = "chris@example.com")
      )
    )
  )
