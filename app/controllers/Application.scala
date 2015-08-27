package controllers


import models.{Route}
import play.api.data.Form

import play.api.mvc._

import play.api.data.Forms._



object Application extends Controller {

  def index = Action {
    Ok(views.html.main())
  }

  def listRoute = Action {
    Ok(views.html.home(Route.fetch)(""))
  }




  def search(start: String, dest: String) = Action {

     val result = Route.fetchByTwoCity(start,dest)


    if (result.isEmpty) {
      val content = "Route not found"
      Ok(views.html.home(result)(content))
    }
    else {
      Ok(views.html.home(result)(""))
    }
  }

  val enquiryForm = Form(tuple("start" -> nonEmptyText, "dest" -> nonEmptyText))


  def ask =Action{
    implicit request => Ok(views.html.indexPage(enquiryForm))
  }

  def enquire =Action{
    implicit request =>  val (fname, lname) = enquiryForm.bindFromRequest.get
      Redirect(routes.Application.search(fname,lname))

  }




}
