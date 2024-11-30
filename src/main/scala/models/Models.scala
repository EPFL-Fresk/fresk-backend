package models

import upickle.default._

case class Event(
  id: Option[Int] = None,
  name: String,
  description: String,
  location: String,
  startTime: String,
  duration: Option[String] = None,
  image: Option[String] = None
) derives ReadWriter

case class Person(
  id: Option[Int] = None,
  name: String,
  role: String,
  telegramHandle: Option[String] = None,
  email: String
) derives ReadWriter

case class Association(
  id: Option[Int] = None,            
  name: String,                      
  subtitle: Option[String] = None,   
  description: String,              
  logo: Option[String] = None,       
  banner: Option[String] = None,     
  activeMembers: Option[Int] = None, 
  events: List[Event] = List.empty,
  imageGallery: List[String] = List.empty, 
  committee: List[Person] = List.empty    
) derives ReadWriter

