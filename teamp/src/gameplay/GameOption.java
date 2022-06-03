package gameplay;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import character.CharacterDAO;
import character.CharacterDTO;
import character.CharacterGenerator;

public class GameOption {
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	CharacterGenerator charGenerator = new CharacterGenerator();
	CharacterDAO cdao = new CharacterDAO();
	GameDAO dao = new GameDAO();

	String[] bossname = { "좀비 햇", "좀비 두 백", "좀비 알감자", "좀비 버뱅크", "좀비 오감자", "좀비 유콘골드", "좀비 남작", "좀비 수미", "좀비 서흥감자",
			"숙주 돼지감자" };
	String str = "revisor,senor,faauto,trespassing,profs,pheonix,seitz,administrivia,foams,leh,orbitals,hammerhead,dotcom,xof,pendent,klezmer,fosgate,walworth,niguel,quickfind,isakmp,edifice,facia,vermin,stalemate,multimediacard,motrin,loosening,glx,classifies,ischia,ankh,mohali,incurs,feist,dialectic,ldb,netzero,rationalization,eef,brokering,viewport,isas,masterbate,tantalizing,geneseo,grammer,rhinoceros,garantie,adjutant,otro,sanofi,malignancies,yaesu,jpegs,spitz,chea,limassol,lobbied,sickening,splat,nostradamus,pondered,gallium,mobb,teil,mannered,dorada,nalin,sorbet,lunenburg,snows,phc,steeper,tdma,rangoon,depriving,bodycare,jobsearch,stalwart,sharia,topiary,cataloged,camsex,verandah,schreiben,buttery,deformity,cronies,avm,kimber,extendable,ager,pella,optometrist,undervalued,tinh,bogey,kana,pipette,bln,invalidity,coveralls,soundly,teng,stayz,isolator,wicking,dank,cph,zany,umatilla,pinkerton,austral,canvases,applauds,taks,weakens,interferometer,barbican,paulus,ohana,ebcdic,rebs,cerf,politik,criminally,mkv,lariat,adio,psychopathology,lkr,leyton,cartoonists,appellees,indira,redraw,pictbridge,mahesh,pursuance,beng,ncar,scapegoat,gord,nanometer,faceless,moyers,oregonian,aftershock,gena,leggett,wsdot,classique,menon,spiro,whiteboards,strategists,dnv,loti,kaos,hydrotherapy,marionette,anathema,islay,myv,typeof,igt,nitty,ddb,quintile,freightliner,monkees,comptes,lindley,dehumidifier,industrials,bouncers,transfered,mages,dmb,roseanne,trifle,chk,trigraphs,rer,bettis,forefathers,cyberlink,piraeus,browsable,xxvi,workhorse,iterated,mcfly,kyd,pooping,eradicated,preferentially,fraternities,diuretic,octubre,castell,emerg,sampras,gephardt,zimbabwean,unexpired,westmorland,biscotti,mavica,toga,everyones,shaikh,nampa,fram,youngblood,plana,refractor,bouldering,flemington,dysphagia,inadmissible,redesigning,milken,xsel,zooplankton,strasburg,gsd,philatelic,berths,modularity,innocuous,parkview,heroines,retake,unpacked,keto,marrone,wallmounting,tias,marengo,gonzalo,quiche,epoc,resales,clenched,maduro,murrieta,fairplay,ddp,groupes,evaporate,woodinville,registro,transcriber,midwinter,notarized,neocons,franchisor,compagnie,bellini,undoing,diab,vying,communes,morehouse,cassava,lauper,bedspreads,pooch,morphism,gripper,tavistock,disappointments,glace,negated,javabeans,nashik,atomki,musicianship,puns,viaggi,bbn,cady,adios,purview,hilt,bosque,xxxl,dyfed,devoured,biomaterials,overpass,inwardly,berners,goaltender,speedometer,adeline,smothered,ultrium,carteret,fatwa,eulogy,bottomed,superscript,rwandan,proteinase,coolermaster,maca,siva,lond,forsythe,pernicious,haircuts,crewneck,fenster,discriminant,bayfield,continua,mishra,morey,babbitt,reims,scrimmage,multiplexers,pcga,stade,privates,whims,hew,carnivore,codingsequence,knowledgealert,egalitarian,pombe,yamato,jenson,mortgagee,skirmish,middlefield,iiyama,schell,midler,roan,nags,caplan,anyplace,haridwar,sternberg,ventilating,retreating,shopsafe,mohave,nonsensical,brion,gallows,immun,zapf,rheumatism,devotee,nieuw,cowardice,fabled,mingus,prolly,trichy,microform,fangs,olsson,animosity,jdc,dosimetry,smelter,rayovac,takeda,mbt,ied,dynamism,wily,fileattachment,rabat,wiles,devs,ensue,mellor,manmade,somaliland,hashtable,sdb,conto,jaffa,furtado,sagging,statics,chemin,crumbled,saleh,puja,kamera,eport,killian,rucksack,janette,sybil,powerware,phenylephrine,cupcake,karp,pekin,defied,bodum,celular,zamora,hopelessness,errand,qian,yeoman,dws,psig,polycystic,titts,slimy,krzysztof,parsippany,unser,raggedy,eason,coerce,epg,bsg,payloads,alon,cebit,overhang,wedgewood,ihren,daten,pbi,jeunes,annexe,cyclen,customizations,stunningly,sobbing,muslin,hugger,junio,jtc,xcd,prequel,strathmore,deliberative,gute,champloo,tattooing,shekels,billerica,talley,estoppel,emigrant,ameritrade,dodo,torr,cytomegalovirus,bpel,domus,madigan,supercool,ysl,contaminate,rxlist,sailormoon,ubid,plovdiv,mcsweeney,govideo,bassinet,taillights,typhimurium,dez,fci,visionaries,salesmen,jahr,thorny,nicki,skagen,hibernation,ponders,rrsp,middleburg,innkeepers,epistles,mcauliffe,gardasee,pcn,asce,aromatics,interplanetary,landcare,towneplace,downloaden,discontinuing,bork,trampled,sealers,weybridge,wusthof,interbank,hullabaloo,erratum,contreras,sandwell,anthracite,novgorod,earbud,jds,coastlines,meditating,echolist,guntur,lmp,trunking,foxtrot,rosanna,patchouli,inequities,testes,defaulting,alpert,merciless,securitization,nsfw,borer,originators,postid,phx,censoring,hashimoto,oriole,chipotle,slocum,ipeople,clump,rdg,reusing,saeed,wetzel,mensa,shiner,chal,rhesus,streptomyces,transcribe,datagrams,invalidated,shenanigans,atrocity,elinor,mkii,sandford,lennart,pract,npi,proportionally,untrained,beene,thrusts,travelguide,championed,biosolids,billable,tiresome,splashed,givers,antonyms,tmdls,cockroaches,testcase,faraway,lune,cfengine,umbc,underwritten,biofuels,cyberhome,dinh,zegna,tarps,sociologists,ellesmere,ostomy,vso,sena,ingest,gazebos,sirloin,moccasins,parthenon,cyclophosphamide,abounds,bitdefender,catz,salutes,collided,bpp,giancarlo,kategorie,tilde,potash,arjan,valery,kmc,boarders,insp,lapping,recomended,dataport,pfaff,manuale,rog,chivalry,niven,mahi,ghs,atsdr,rangeland,commonality,xid,midis,cwc,regrettably,navidad,yahoogroups,kaw,corazon,ston,ves,pulau,playbook,digipak,frustrate,jetblue,kavanagh,exhibitionists,armidale,sideboard,arquette,copland,namib,cne,poaching,cheapflights,wyvern,lucene,montmartre,muffled,vincennes,inlays,lockets,whitey,foiled,brin,wharfedale,guyanese,laryngeal,outfielder,nonattainment,softimage,cellgroupdata,literatura,myoplex,yorba,flocked,bct,pva,slapstick,cottrell,connaught,dialers,subculture,cmx,modded,skids,roselle,tether,klub,hyperbole,marathons,tgt,skeet,toucan,masterclass,borghese,nnp,calcio,oxidizing,alo,kennebec,zj,schrieb,intergalactic,biomolecular,cii,brahman,powweb,mcwilliams,phosphorous,charlemagne,pulsing,photocopiers,obligor,matcher,listbox,voigt,fdl,heralds,sterility,dawley,scribus,lessors,dynasties,prowl,npn,luminaries,karats,bridger,amiable,slm,hadronic,akt,fairport,piecewise,sittings,undulating,recharging,dmm,thatched,felice,unionville,intermedia,goetz,esto,urinal,joystiq,grosso,sobaka,payphone,rockfish,duodenal,uninstalled,leiter,irrevocably,coworker,escuela,cyclades,longterm,taber,bunyan,screenplays,gpt,shiites,ntop,farcry,hinders,jitsu,tubers,lactobacillus,uniontown,cloner,unrelenting,otaku,hoyas,kandahar,kerrville,akers,neuropsychology,multimap,expeditiously,antiquated,jerked,allston,sputtering,femininity,opulent,trask,accuweather,deferment,mots,dimly,wam,fmp,portlets,coconuts,confuses,executors,glsa,westmont,waders,squall,cellulare,homehome,frogger,hass,rya,nothingness,seqres,hellfire,hebrides,havering,montfort,chokes,eharmony,knowsley,demeter,bordellchat,cvsweb,houdini,umr,canarias,babyshambles,bridgette,antagonistic,cinque,bowery,immovable,drezner,hsin,caterpillars,alcan,stas,outlier,naira,neverending,consigned,masson,khanna,rhein,systeme,fervor,pret,hillsong,camshaft,exotica,milburn,scooped,bijou,destdir,innervation,gga,oqo,cunha,reefer,exerts,techspot,hibernia,alpina,iarc,constraining,nym,idling,dard,estefan,fuser,lepton,pergamon,cursory,wiktionary,razer,poznan,netscreen,manda,npv,xmb,kingstown,topix,dissipate,batsman,hymen,wavelets,cogs,bigtitsroundasses,barnhart,scofield,ebrd,desorption,refuted,bellflower,watertight,ionian,stevia,americanism,photocopier,haverford,talc,pessimism,penises,vehemently,gwendolyn,buynow,nairn,prolab,lundberg,velvety,backordered,coh,mononuclear,vedere,unocal,wheezing,brunson,greenlee,emer,txdot,prichard,conferees,renata,ternary,footballer,sisyphus,directfb,foolproof,chastain,lakshmi,dsb,teeming,paradoxes,megane,lampe,cdo,someones,foolishly,ordre,rebelde,morrigan,mymovies,tiananmen,immunosuppressive,mcveigh,stylin,brower,mpltext,eer,inanimate,panting,aibo,pdd,depositor,ofcourse,comers,ecdl,redenvelope,acidophilus,deci,defensively,romaine,wulf,analytica,cnd,hrp,tnr,tryon,peckham,forgo,barca,pahrump,foros,tacks,pickabook,veille,hellraiser,lithographs,effusion,educates,ediets,gopal,lunacy,signers,digext,netbackup,dimensionality,triax,rnase,aman,angell,loathe,bochum,eyepieces,earbuds,americablog,makeovers,unprocessed,pfa,widctlpar,clausen,punbb,notoriety,centra,monson,infogrames,azt,xalan,hydroxyl,medpix,showered,interacted,gpi,polishes,brats,canoga,huddle,numismatic,avoidable,brantley,adenoma,aah,prostaglandins,powercolor,beaconsfield,lakhs,mhd,lesbisch,flammability,truancy,taxicab,jharkhand,channelweb,confounded,givn,flatiron,midlife,guerin,coughs,indianola,unavailability,rooter,wanaka,lompoc,widener";
	
	
	//타이핑 속도 측정
	public long typingSec() {
		//split 및 랜덤 영단어 출력.
		String[] arr = str.split(",");
		int i = r.nextInt(arr.length);
		System.out.println("--"+arr[i] + "-- 입력하세요");
		long timeFirst = System.currentTimeMillis();
		String str = sc.next();
		long timeDif = System.currentTimeMillis() - timeFirst;
		long typing = str.length()  * 90 / ((timeDif / 1000) + 1);
		System.out.println(typing + "타");
		if (arr[i].equals(str)) {
			return typing;
		} else {
			System.out.println("Miss");
			return 0;
		} //
	}

// 보스 체력바	, 보스네임
	public void HpBar(int bossHp, int i) {
		System.out.println("---" + bossname[i] + "---");
		System.out.println("남은 보스 체력 : " + bossHp);
		int hpBar = bossHp / (1000 + 500 * i);
		for (int j = 0; j < hpBar + 1; j++) {
			System.out.print("■");
		}
		for (int j = 0; j < 10 - hpBar; j++) {
			System.out.print("□");
		}
		System.out.println();
	}

// 캐릭터 생성
	public CharacterDTO characterProduct(int num, String user_id) {
		CharacterDTO cdto = new CharacterDTO();
		int i =0;
		while (true) {
			if(i>=1) {System.out.println("닉네임이 중복되었습니다");}
			String nick = charGenerator.charNickname();
			while (true) {
				cdto = charGenerator.mainchar(nick); 
				System.out.println("캐릭터 능력치를 돌리겠습니까");
				System.out.println("[1] 돌린다 [2] 이대로 간다");
				num = sc.nextInt();
				if (num == 2) {
					// 만든 캐릭터를 등록시킨다
					if (cdao.CharacterBuild(cdto, user_id) == 1) {
						break;
					}
					return cdto;
				} else if (num == 1) {

				} else {
					System.out.println("번호를 잘못 입력 하셨습니다.");
				}
			}
			i++;
			if (cdao.CharacterBuild(cdto, user_id) == 0) {
				break;
			}

		} return cdto;
	}

// 게임 오프닝 문구
	public void opening() {
		String str = "때는 20XX년\r\n" + "강원도 대관령에서 감자 품질향상 연구 진행 중\r\n"
				+ "연구원의 실수로 감자가 아닌 돼지감자에 감자DNA를 투여하여 좀비 확찐자 바이러스가 발발했다.\r\n"
				+ "한국정부는 좀비 확찐자 바이러스를 없애기위해 미국정부에 FBI 지원요청을 하여\r\n" + "좀비 확찐자 바이러스를 없애기 시작한다.";
		char[] arr = new char[str.length()];

		try {
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
				System.out.print(arr[i]);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
		}
		System.out.println();
	}

// 캐릭터 정보 출력
	public void characterView(String user_id) {
		dao.connect();
		dao.characterView(user_id);
		dao.close();
	}

}
