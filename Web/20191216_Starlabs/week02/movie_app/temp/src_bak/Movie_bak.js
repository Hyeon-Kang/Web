import React from 'react';
import PropTypes from 'prop-types'
import './Movie.css';


title
poster
genres
synopsis


class Movie extends Component {

    static propTypes = {
        title: PropTypes.string.isRequired,
        poster: PropTypes.string.isRequired
    }
    componentWillMount() {

    }

    componentDidMount() {

    }
    render() {

        return (
            <div>
                <MoviePoster poster={this.props.poster} />
                <h2>{this.props.title}</h2>
            </div>
        );
    }
}

class MoviePoster extends Component {
    static propTypes = {
        poster: PropTypes.string.isRequired
    }
    render() {

        return (
            <img src={this.props.poster} alt="" />
        );
    }
}
export default Movie;
