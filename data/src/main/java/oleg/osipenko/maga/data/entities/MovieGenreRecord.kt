package oleg.osipenko.maga.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.ForeignKey.NO_ACTION
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * MoviesDb entity linking together movie and genre
 */
@Entity(
        tableName = "movie_genres",
        indices = arrayOf(Index("movieId"), Index("genreId")),
        foreignKeys = [
            (ForeignKey(
                    entity = MovieRecord::class,
                    parentColumns = ["id"],
                    childColumns = ["movieId"],
                    onUpdate = CASCADE,
                    onDelete = NO_ACTION)),
            (ForeignKey(
                    entity = GenreRecord::class,
                    parentColumns = ["id"],
                    childColumns = ["genreId"],
                    onUpdate = CASCADE,
                    onDelete = NO_ACTION))]
)
data class MovieGenreRecord(
        @PrimaryKey val id: String = UUID.randomUUID().toString(),
        val movieId: Int,
        val genreId: Int
)