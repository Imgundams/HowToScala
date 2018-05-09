import java.time.LocalDate
import java.time.Year

val dateOfBirth = LocalDate.of(1992, 5, 2)
val timebetween = LocalDate.now.compareTo(dateOfBirth)
//private def CurrentAgeFromDateOfBirth(dateOfBirth:LocalDate):Year ={}

println("Hello, your date of birth is " + dateOfBirth.toString)
println("This is your " + timebetween + " year")


private def CurrentAgeFromDateOfBirth(dateOfBirth: LocalDate): Int = {

  if (LocalDate.now.getDayOfYear >= dateOfBirth.getDayOfYear-1) LocalDate.now.getYear - dateOfBirth.getYear
  else LocalDate.now.getYear - dateOfBirth.getYear - 1

}
println("Age: "+CurrentAgeFromDateOfBirth(dateOfBirth))