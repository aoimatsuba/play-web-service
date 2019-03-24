package controllers

import com.google.inject.Inject
import models.Stock
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

// Controller is deprecated
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  // In order to check application running
  def index = Action {
    Ok("Application is ready!")
  }

  // get stock price GET request
  def getStock = Action {
    val stock = Stock("Noot", 45.3)
    Ok(Json.toJson(stock))
  }

  // save stock info POST request
  def saveStock = Action { request =>
    val json = request.body.asJson.get
    val stock = json.as[Stock]
    println(stock)
    Ok
  }
}