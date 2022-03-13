import { ReactComponent as GitIcon } from 'assets/img/Vector.svg';
import './styles.css'

function NavBar() {

    return (
        <header>
            <nav className='container'>
                <div className='dsmovie-nav-content'>
                    <h1>DSMovie</h1>
                    <a href="https://github.com/Falchizao">
                        <div className="dsmovie-contact-container">
                            <GitIcon />
                            <p>/Falchizao</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    )
}

export default NavBar;