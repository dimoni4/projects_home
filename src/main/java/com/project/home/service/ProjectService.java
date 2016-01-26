package com.project.home.service;

import com.project.home.models.entity.*;
import com.project.home.repository.ProjectRepository;
import com.project.home.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@org.springframework.stereotype.Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    protected void initialize() {
        userRepository.save(new User("ilshyma", "123", "ROLE_USER"));
        userRepository.save(new User("admin", "admin", "ROLE_ADMIN"));

        User vetrov = new User("vetrovs@ua.fm", "123", "ROLE_USER");
        userRepository.save(vetrov);


        projectRepository.save(
                new Project()
                        .setName("ОЧ - В интернете")
                        .setDescription("Интернет Оплата частями")
                        .setActive(true)
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "https://payparts2.privatbank.ua/ipp/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "предлагаем"))
                                .setDescription("боевой инстанс")
                                .setVersion("2.102"))
                        .add(new Instance(Instance.Type.TEST, "https://brtp.test.it.loc/ipp/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "предлагаем"))
                                .setDescription("тестовый инстанс")
                                .setVersion("2.371"))
                        .add(new Instance(Instance.Type.STAGE, "https://brtp-stage.test.it.loc/ipp/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "предлагаем"))
                                .setDescription("предрелиз")
                                .setVersion("2.105"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/pp_internet/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=pp_internet"))
                        .add(new Service(Service.Type.LOG, "http://10.1.109.51:9000/apache-tomcat-payparts2.privatbank.ua/pp_internet/"))
                        .add(new Service(Service.Type.LOG_TEST, "http://10.1.108.192:9000/pp_internet/pp_internet/"))
                        .add(new Service(Service.Type.LOG_TEST, "http://10.56.0.34:9000/pp_internet/pp_internet/"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/pp_internet"))
        );

        projectRepository.save(
                new Project()
                        .setName("ОЧ - Автозаведение")
                        .setDescription("Best project")
                        .setActive(true)
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "https://pporder.privatbank.ua/pp-order/sandbox")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Возникла"))
                                .setVersion("1.1"))
                        .add(new Instance(Instance.Type.TEST, "https://brtp.test.it.loc/pp-order/sandbox")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "google"))
                                .setVersion("1.2"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/pp_order"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/pp_order/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=pp_order"))
                        .add(new Service(Service.Type.LOG, "http://10.61.128.47:9000/pp-opder/pp_order/"))
                        .add(new Service(Service.Type.LOG_TEST, "http://10.1.108.192:9000/pp_order/pp_order/"))
        );

        projectRepository.save(
                new Project()
                        .setName("ОЧ - Виджет лимита")
                        .setDescription("Best project")
                        .setActive(true)
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.TEST, "https://brtp.test.it.loc/pp-limit/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Доступная"))
                                .setVersion("1.1"))
                        .add(new Instance(Instance.Type.PROD, "https://paypartslimit.privatbank.ua/pp-limit/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Доступная"))
                                .setVersion("1.2"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/pp_limit"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/pp_limit/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=pp_limit"))
                        .add(new Service(Service.Type.LOG_TEST, "http://10.1.108.192:9000/pp_limit/pp_limit/"))
                        .add(new Service(Service.Type.LOG, "http://10.1.109.51:9000/apache-tomcat-paypartslimit.privatbank.ua/pp_limit/"))
        );

        projectRepository.save(
                new Project()
                        .setName("ОЧ - Калькулятор")
                        .setDescription("Best project")
                        .setActive(true)
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "https://ppcalc.privatbank.ua/pp_calculator/phys")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Оплата"))
                                .setVersion("1.1"))
                        .add(new Instance(Instance.Type.TEST, "https://brtp.test.it.loc/pp_calculator/phys")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Оплата"))
                                .setVersion("1.2"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/pp_calculator"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/pp_calculator/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=pp_calculator"))
                        .add(new Service(Service.Type.LOG_TEST, "http://10.1.108.192:9000/pp_calculator/"))
                        .add(new Service(Service.Type.LOG, "http://10.61.128.47:9000/pp-calculator/"))
        );

        projectRepository.save(
                new Project()
                        .setName("ОЧ - Карта точек")
                        .setDescription("Best project")
                        .setActive(true)
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "https://ppmap.privatbank.ua/pp_map/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Оплата"))
                                .setVersion("1.1"))
                        .add(new Instance(Instance.Type.TEST, "http://10.56.0.34:8006/pp_map/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Оплата"))
                                .setVersion("1.2"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/pp_map"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/pp_map/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=pp_map"))
                        .add(new Service(Service.Type.LOG_TEST, "http://10.56.0.34:9000/pp_map/pp_map/"))
                        .add(new Service(Service.Type.LOG, "http://10.61.128.47:9000/pp-map/"))
        );

        projectRepository.save(
                new Project()
                        .setName("ОЧ - Рабочий стол")
                        .setDescription("Best project")
                        .setActive(true)
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "http://10.1.109.51:8008/installment-plan/test")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Авторизация"))
                                .setVersion("1.1"))
                        .add(new Instance(Instance.Type.TEST, "http://10.56.0.34:8007/installment-plan/pp/test")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Ошибка"))
                                .setVersion("1.2"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/pp_desktop"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/pp_desktop/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=pp_desktop"))
                        .add(new Service(Service.Type.LOG_TEST, "http://10.56.0.34:9000/pp_desktop/pp_desktop/"))
                        .add(new Service(Service.Type.LOG, "http://10.1.109.51:9000/apache-tomcat-brtp.privatbank.ua-installment-plan/pp_desktop/"))
        );

        projectRepository.save(
                new Project()
                        .setName("ОЧ - Сайт")
                        .setDescription("Best project")
                        .setActive(true)
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance()
                                .setUrl("http://10.56.0.34:8003/pp/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "РАССРОЧКА"))
                                .setStatus(Status.UNKNOWN)
                                .setType(Instance.Type.PROD)
                                .setVersion("1.1"))
                        .add(new Instance()
                                .setUrl("http://chast.privatbank.ua/pp_site/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "РАССРОЧКА"))
                                .setStatus(Status.UNKNOWN)
                                .setType(Instance.Type.TEST)
                                .setVersion("1.2"))
                        .add(new Service()
                                .setType(Service.Type.GIT)
                                .setUrl("https://git.privatbank.ua/fe/pp_site")
                                .setStatus(Status.UNKNOWN))
                        .add(new Service()
                                .setType(Service.Type.JENKINS)
                                .setUrl("http://10.1.98.135:8000/view/Applications/job/pp_site/")
                                .setStatus(Status.UNKNOWN))
                        .add(new Service()
                                .setType(Service.Type.SONAR)
                                .setUrl("http://10.1.98.135:8001/dashboard/index?id=pp_site")
                                .setStatus(Status.UNKNOWN))
                        .add(new Service()
                                .setType(Service.Type.LOG)
                                .setUrl("http://10.56.0.34:9000/pp_site/Part_payment_site/")
                                .setStatus(Status.UNKNOWN))
        );

        projectRepository.save(
                new Project()
                        .setName("ОЧ - Товары в интернете")
                        .setDescription("Best project")
                        .setActive(true)
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance()
                                .setUrl("http://10.56.0.34:8005/sos/offers?q=nokia")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "name"))
                                .setStatus(Status.UNKNOWN)
                                .setType(Instance.Type.PROD)
                                .setVersion("1.1"))
                        .add(new Instance()
                                .setUrl("https://ppshop.privatbank.ua/sos/offers?q=nokia")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "name"))
                                .setStatus(Status.UNKNOWN)
                                .setType(Instance.Type.TEST)
                                .setVersion("1.2"))
                        .add(new Service()
                                .setType(Service.Type.GIT)
                                .setUrl("https://git.privatbank.ua/fe/pp_offers")
                                .setStatus(Status.UNKNOWN))
                        .add(new Service()
                                .setType(Service.Type.JENKINS)
                                .setUrl("http://10.1.98.135:8000/view/Applications/job/pp_offers/")
                                .setStatus(Status.UNKNOWN))
                        .add(new Service()
                                .setType(Service.Type.SONAR)
                                .setUrl("http://10.1.98.135:8001/dashboard/index?id=pp_offers")
                                .setStatus(Status.UNKNOWN))
                        .add(new Service()
                                .setType(Service.Type.LOG)
                                .setUrl("http://10.56.0.34:9000/pp_offers/sos/")
                                .setStatus(Status.UNKNOWN))
        );

        projectRepository.save(
                new Project()
                        .setName("ОЧ - Кредитный брокер")
                        .setDescription("Best project")
                        .setActive(true)
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance()
                                .setUrl("https://brtp.test.it.loc/credit-broker/sandbox/login")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Авторизация"))
                                .setStatus(Status.UNKNOWN)
                                .setType(Instance.Type.TEST)
                                .setVersion("1.1"))
                        .add(new Instance()
                                .setUrl("https://credits.privatbank.ua/broker/sandbox")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Авторизация"))
                                .setStatus(Status.UNKNOWN)
                                .setType(Instance.Type.PROD)
                                .setVersion("1.2"))
                        .add(new Service()
                                .setType(Service.Type.GIT)
                                .setUrl("https://git.privatbank.ua/fe/pp_credit_broker")
                                .setStatus(Status.UNKNOWN))
                        .add(new Service()
                                .setType(Service.Type.JENKINS)
                                .setUrl("http://10.1.98.135:8000/view/Applications/job/pp_credit_broker/")
                                .setStatus(Status.UNKNOWN))
                        .add(new Service()
                                .setType(Service.Type.SONAR)
                                .setUrl("http://10.1.98.135:8001/dashboard/index?id=pp_credit_broker")
                                .setStatus(Status.UNKNOWN))
                        .add(new Service()
                                .setType(Service.Type.LOG)
                                .setUrl("http://10.1.108.192:9000/pp_credit_broker/pp_credit_broker/")
                                .setStatus(Status.UNKNOWN))
        );

        projectRepository.save(
                new Project()
                        .setName("ОЧ - Деньги до зарплаты/Быстрые наличные")
                        .setDescription("Best project")
                        .setActive(true)
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance()
                                .setUrl("http://10.56.0.34:8010/pp_cash_credit/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Деньги"))
                                .setStatus(Status.UNKNOWN)
                                .setType(Instance.Type.TEST)
                                .setVersion("1.1"))
                        .add(new Instance()
                                .setUrl("https://occ.a-bank.com.ua/cash/beforesalary?locale=ru")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Деньги"))
                                .setStatus(Status.UNKNOWN)
                                .setType(Instance.Type.PROD)
                                .setVersion("1.2"))
                        .add(new Service()
                                .setType(Service.Type.GIT)
                                .setUrl("https://git.privatbank.ua/fe/pp_cash_credit")
                                .setStatus(Status.UNKNOWN))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Partial%20Payment/job/pp_cash_credit/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index/pp_cash_credit"))
                        .add(new Service(Service.Type.LOG, "http://10.56.0.34:9000/pp_cash_credit/stdout/"))
        );

        projectRepository.save(
                new Project("ОЧ - Выписки по терминалам")
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "https://terminalexcerpts.privatbank.ua/excerpts/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Авторизация"))
                                .setVersion("1.1"))
                        .add(new Instance(Instance.Type.TEST, "https://brtp.test.it.loc/excerpts/sandbox")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Авторизация"))
                                .setVersion("1.2"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/acq_excerpts"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/acq_excerpts/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=acq_excerpts"))
                        .add(new Service(Service.Type.LOG, "http://10.1.108.192:9000/acq_excerpts/acq_excerpts/"))
                        .add(new Service(Service.Type.LOG, "http://10.1.109.51:9000/apache-tomcat-terminalexcerpts.privatbank.ua/acq_excerpts/"))
        );

        projectRepository.save(
                new Project("Эквайринг - Мои торговые точки")
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "https://brtp.test.it.loc/brtp_trading_points/sandbox")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "сендбокс"))
                                .setVersion("1.1"))
                        .add(new Instance(Instance.Type.TEST, "https://tradingpoints.privatbank.ua/trading-points/sandbox")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Возникла"))
                                .setVersion("1.2"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/acq_trading_points"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/acq_trading_points/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=acq_trading_points"))
                        .add(new Service(Service.Type.LOG, "http://10.1.108.192:9000/acq_trading_points/stdout/"))
                        .add(new Service(Service.Type.LOG, "http://10.1.96.157:9000/apache-tomcat-tradingpoints.privatbank.ua/acq_trading_points/"))
        );

        projectRepository.save(
                new Project("Эквайринг - Обучения для кассиров")
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "https://cashierstudy.privatbank.ua/tsp-learning/index?locale=ru_RU&version=1.0-SNAPSHOT.137&applicationLevel=PRODUCTION")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "директоров"))
                                .setVersion("1.1"))
                        .add(new Instance(Instance.Type.TEST, "http://10.56.0.34:8009/tsp-learning/index?locale=ru_UA&version=1.4&applicationLevel=TEST")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "директоров"))
                                .setVersion("1.2"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/acq_cashier_studying"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/acq_cashier_studying/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=acq_cashier_studying"))
                        .add(new Service(Service.Type.LOG, "http://10.56.0.34:9000/acq_cashier_studying/acq_cashier_studying/"))
                        .add(new Service(Service.Type.LOG, "http://10.1.109.51:9000/apache-tomcat-cashierstudy.privatbank.ua/acq_cashier_studying/"))
        );

        projectRepository.save(
                new Project("Эквайринг - Операции в П48")
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "http://brtp.privatbank.ua/p48_interfaces/"))
                        .add(new Instance(Instance.Type.TEST, "http://10.56.0.34:8008/p48_interfaces/"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/acq_operations"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/acq_operations/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=acq_operations"))
                        .add(new Service(Service.Type.LOG, "http://10.1.109.51:9000/apache-tomcat-brtp.privatbank.ua-p48_interfaces/"))
                        .add(new Service(Service.Type.LOG, "http://10.56.0.34:9000/asq_operations/"))
        );

        projectRepository.save(
                new Project("Конвейер - Конструктор таблиц")
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "http://10.56.0.34:8001/constructor/api")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "директоров"))
                                .setVersion("1.1"))
                        .add(new Instance(Instance.Type.TEST, "http://10.56.0.34:8008/p48_interfaces/")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "директоров"))
                                .setVersion("1.2"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/conveyor_table_constructor"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/conveyor_table_constructor/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=conveyor_table_constructor"))
                        .add(new Service(Service.Type.LOG, "http://10.56.0.34:9000/conveyor_table_constructor/table_constructor/"))
                        .add(new Service(Service.Type.LOG, "http://10.1.96.157:9000/apache-tomcat-convtables.privatbank.ua/table_constructor/"))
        );

        projectRepository.save(
                new Project("Конвейер - Плагины")
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "https://brtp.test.it.loc/siteheart_plugin/api")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "конвейера"))
                                .setVersion("1.1"))
                        .add(new Instance(Instance.Type.TEST, "http://10.61.128.47:81/siteheart_plugin/api")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "конвейера"))
                                .setVersion("1.2"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/conveyor_api"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/conveyor_api/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=conveyor_api"))
                        .add(new Service(Service.Type.LOG, "http://10.1.108.192:9000/conveyor_api/conveyor_api/"))
                        .add(new Service(Service.Type.LOG, "http://10.61.128.47:9000/siteheart-plugin/"))
        );

        projectRepository.save(
                new Project("Страхование - Физ лица")
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "https://insur.privatbank.ua/PbInsuranceFrontend/myinsur/ua.htm?lang=ua&source=pb")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "мобільного"))
                                .setVersion("1.1"))
                        .add(new Instance(Instance.Type.TEST, "http://10.56.0.26:8080/PbInsuranceFrontend/test")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "мобільного"))
                                .setVersion("1.2"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/insur_phys"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/insur_phys/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=insur_phys"))
        );

        projectRepository.save(
                new Project("Страхование - ПриватФонд")
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "http://10.61.129.220:8000/PbInsuranceFrontend/privatfond/ru")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Среднегодовая"))
                                .setVersion("1.1"))
                        .add(new Instance(Instance.Type.TEST, "http://10.56.0.26:8082/PbInsuranceFrontend/privatfond/ru")
                                .setCheckCreteria(new CheckCreteria(CheckCreteria.Type.SEARCH_WORD, "Среднегодовая"))
                                .setVersion("1.2"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/insur_privat_fond"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/insur_privat_fond/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=insur_privat_fond"))
        );

        projectRepository.save(
                new Project("Страхование - Админка")
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "http://10.56.0.26:8080/PbInsurance/delivery")
                                        .setVersion("1.1")
                        )
                        .add(new Instance(Instance.Type.TEST, "http://10.56.0.26:8080/PbInsurance/")
                                        .setVersion("1.2")
                        )
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=insur_phys_admin"))
                        .add(new Service(Service.Type.LOG, "http://10.1.102.148:9090/apache-tomcat-PbInsuranceFrontend/"))
                        .add(new Service(Service.Type.LOG, "http://10.61.129.220:9090/apache-tomcat-PbInsuranceFrontend"))
        );

        projectRepository.save(
                new Project("Страхование - Плагины для конвейера")
                        .add(new Access(Access.Type.OWNER, vetrov))
                        .add(new Instance(Instance.Type.PROD, "http://10.56.0.26:8080/service/conv/"))
                        .add(new Instance(Instance.Type.TEST, "http://10.56.0.26:8082/service/conv"))
                        .add(new Service(Service.Type.GIT, "https://git.privatbank.ua/fe/insur_api"))
                        .add(new Service(Service.Type.JENKINS, "http://10.1.98.135:8000/view/Applications/job/insur_api/"))
                        .add(new Service(Service.Type.SONAR, "http://10.1.98.135:8001/dashboard/index?id=insur_api"))
        );
    }


}


