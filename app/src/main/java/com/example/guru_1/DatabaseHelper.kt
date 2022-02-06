import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.BitmapFactory
import android.widget.Toast
import android.os.BaseBundle

data class Memo(var no: Long?, var image: ByteArray?)


class DatabaseHelper(context: Context, name: String, version: Int) :
        SQLiteOpenHelper(context, name, null, 3) {

    override fun onCreate(db: SQLiteDatabase?) { //DB 테이블 생성

        val create = "Create Table memo ("+  //쿼리문
                "no integer primary key, "+
                "image blob" +
                ")"
        db?.execSQL(create)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (newVersion > oldVersion) {
            db?.execSQL("ALTER TABLE ADD_NAME ADD COLUMN NEW_COLOUM INTEGER DEFAULT 0"); // You can add TEXT Field
        }
    }

    fun insertData(memo: Memo){ //데이터 삽입
        val values = ContentValues() //map과 같은 키-값 형태의 자료구조
        values.put("image", memo.image)

        val wd = writableDatabase
        wd.insert("memo", null, values) //memo 테이블에 values 넣기
        wd.close()
    }


    fun getdata(): MutableList<Memo> { //데이터 불러오기
        val list = mutableListOf<Memo>()
        val select = "select * from memo"
        val rd = readableDatabase
        val cursor = rd.rawQuery(select, null)
        DatabaseUtils.dumpCursor(cursor)

        while(cursor.moveToNext()){
            var no = cursor.getLong(cursor.getColumnIndex("no").toInt())
            val image: ByteArray? = cursor.getBlob(cursor.getColumnIndex("image").toInt()) ?: null
            list.add(Memo(no, image))
        }
        cursor.close()
        rd.close()
        return list
    }

    fun deleteMemo(){
        val delete = "delete from memo"
        val db = writableDatabase
        db.execSQL(delete)
        db.close()
    }

}

