import{ReactComponent as StarFull} from 'assets/img/StarFull.svg';
import{ReactComponent as StarHalf} from 'assets/img/StarHalf.svg';
import{ReactComponent as StarEmpty} from 'assets/img/StarEmpty.svg';
import './styles.css';


function MovieStars() {
    return (
        <div className="dsmovie-stars-container">
            <StarFull />
            <StarFull />
            <StarFull />
            <StarHalf />
            <StarEmpty />
        </div>
    );
}

export default MovieStars;