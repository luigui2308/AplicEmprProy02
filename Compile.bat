PATH=D:\Program Files\Java\jdk1.7.0_05\bin

::Model
javac -cp "tickets\WEB-INF\classes";"tickets\WEB-INF\lib\*" -d tickets\WEB-INF\classes src\model\Customer.java src\model\CustomerRepository.java src\model\Event.java src\model\EventRepository.java src\model\EventType.java src\model\EventTypeRepository.java src\model\Location.java src\model\LocationRepository.java src\model\LocationType.java src\model\LocationTypeRepository.java src\model\NumberedLocation.java src\model\NumberedLocationRepository.java src\model\Promoter.java src\model\PromoterRepository.java src\model\Role.java src\model\RoleByUser.java src\model\RoleByUserRepository.java src\model\RoleRepository.java src\model\SQLiteDialect.java src\model\Ticket.java src\model\TicketRepository.java src\model\User.java src\model\UserRepository.java

::Data
javac -cp "tickets\WEB-INF\classes";"tickets\WEB-INF\lib\*" -d tickets\WEB-INF\classes src\data\CustomerDAO.java src\data\CustomerFactory.java src\data\EventDAO.java src\data\EventFactory.java src\data\EventTypeDAO.java src\data\EventTypeFactory.java src\data\LocationDAO.java src\data\LocationFactory.java src\data\LocationTypeDAO.java src\data\LocationTypeFactory.java src\data\NumberedLocationDAO.java src\data\NumberedLocationFactory.java src\data\PromoterDAO.java src\data\PromoterFactory.java src\data\RoleByUserDAO.java src\data\RoleByUserFactory.java src\data\RoleDAO.java src\data\RoleFactory.java src\data\TicketDAO.java src\data\TicketFactory.java src\data\UserDAO.java src\data\UserFactory.java

::Controller
javac -cp "tickets\WEB-INF\classes";"tickets\WEB-INF\lib\*" -d tickets\WEB-INF\classes src\controller\EventController.java src\controller\PromoterController.java src\controller\TicketController.java src\controller\UserController.java

pause