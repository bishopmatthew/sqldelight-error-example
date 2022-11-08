import com.airlocksoftware.MyDatabase
import com.airlocksoftware.PlayerQueries
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import sqldelight.com.squareup.sqlite.migrations.Database

fun main(args: Array<String>) {
    val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    MyDatabase.Schema.create(driver)
    val database = MyDatabase(driver)
    print(database.playerQueries.selectAll().executeAsOne())
}